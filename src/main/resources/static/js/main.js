
const arrowButton = document.getElementsByClassName('arrow-button')[0];
const resource = document.getElementById('resources');
const resourceArrow = function() {
    if (arrowButton.innerHTML === '▼') {
        arrowButton.innerHTML = '▲';
        resource.style.height = 'auto';
    } else {
        arrowButton.innerHTML = '▼';
        resource.style.height = '50px';
    }
}
arrowButton.onclick = resourceArrow;




const numFormat = num => {
    if(num < 0){
        return '0' + 0;
    }
    else if(num < 10){
        return '0' + num;
    } else {
        return num;
    }
}



const buildButton = document.getElementById("build-button");
const buildSection = document.getElementById("build");
const buildDisplay = function(){
    buildSection.style.display = (buildSection.style.display == "none") ? 'flex' : 'none';
}
buildButton.onclick = buildDisplay;



async function updateLumbermillUI() {
    const response = await fetch('/api/LM');
    const data = await response.json();

    document.querySelector('.lumbermill .count').innerText = numFormat(data.buildingCount);
    document.querySelector('.woodWorker span').innerText = numFormat(data.maxWorkers);
}

async function updateResourceData() {
    const response = await fetch('/api/resourceData')
    const data = await response.json();
    Object.entries(data).forEach(([key, value]) => {
        let el = (document.querySelector('.' + key + '-amount'))
        if(el)
            el.innerText = numFormat(value);
    });
}

async function production() {
    const response = await fetch('/api/production', { method: 'POST' });
    updateResourceData(); // To refresh resource display
}

// Call once immediately, then every 10 seconds

document.querySelectorAll('.plus-button').forEach(button => {
    button.addEventListener('click', async () => {
        const workerDiv = button.parentElement;
        const span = workerDiv.querySelector('span');
        const buildingDiv = workerDiv.closest('.building')
        const building = buildingDiv.parentElement.id;
        const workerType = workerDiv.closest('.worker').classList[1];
        let number = await addWorker(building, workerType);
        // span.innerHTML = numFormat(number);
    });
});

document.querySelectorAll('.minus-button').forEach(button => {
    button.addEventListener('click', async () => {
        const workerDiv = button.parentElement;
        const span = workerDiv.querySelector('span');
        const buildingDiv = workerDiv.closest('.building')
        const building = buildingDiv.parentElement.id;
        const workerType = workerDiv.closest('.worker').classList[1];
        let number = await subtractWorker(building, workerType);
        span.innerHTML = numFormat(number);
    });
});


async function addWorker(buildingType, resourceWorker){
    const response = await fetch('/api/addWorker', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            'buildingName': buildingType,
            'workerType': resourceWorker
        })

    });
    const data = await response.json();
    console.log(data);
    return data;
    
}

async function subtractWorker(buildingType, resourceWorker){
    const response = await fetch('/api/' + buildingType + "/subtractWorker/" + resourceWorker, {method: 'POST'});
    const data = await response.json();
    return data;
}

document.querySelectorAll('#build img').forEach(build => {
    build.addEventListener('click', async () =>{
        const buildType = build.id;
        console.log(buildType);
        const buildTime = await newBuilding(buildType);
        console.log(buildTime);
        if(buildTime > 0){
            newBuild(buildType, buildTime);
        }
    })
})

async function newBuilding(buildingType){
    const response = await fetch('/api/' + buildingType + '/buildStart', {method: 'POST'})
    const data = await response.json();
    return data;
}

function newBuild(buildType, buildTime){
    setTimeout(async() => {
        let response = await fetch('/api/' + buildType + '/buildFinish', {
            method: 'POST'
        });
        response.then(updateBuildingCount(buildType));
    }, buildTime);

    let construction = document.getElementsByClassName('underConstruction')[0];

    let divNewConstruction = document.createElement('div');
    divNewConstruction.className = 'newConstruction';

    let img = document.createElement('img');
    img.src = `assets/images/buildings/${buildType}.png`;

    let divProgressBar = document.createElement('div');
    divProgressBar.className = 'progress-bar';

    let divBuildingCompletion = document.createElement('div');
    divBuildingCompletion.className = 'buildingCompletion';

    divProgressBar.appendChild(divBuildingCompletion);
    divNewConstruction.appendChild(img);
    divNewConstruction.appendChild(divProgressBar);
    construction.appendChild(divNewConstruction);
    let workTime = 0;
    let interval = setInterval(() => {
        workTime += 100;
        let percent = Math.min((workTime / buildTime) * 100, 100);
        divBuildingCompletion.style.width = percent + "%";

        if (workTime >= buildTime) {
            clearInterval(interval);
            construction.removeChild(divNewConstruction);
            
        }
    }, 100);
}


let updateBuildingCount = async function(buildType){
    let response = await fetch('api/buildingCount')
    let data = await response.json();
    console.log(data);
    let building = document.getElementById(buildType);
    console.log(building.children[0].children[0])
    building.children[0].children[0].innerText = numFormat(data);
}

let updateBuildingStats = async function(){
    let response = await fetch('api/buildingStats');
    let data = await response.json();
    console.log(data);
}

setInterval(updateBuildingStats, 10000)

// setInterval(production, 10000);

// updateResourceData();
// updateWorkerCount();
// updateBuildingCount();
