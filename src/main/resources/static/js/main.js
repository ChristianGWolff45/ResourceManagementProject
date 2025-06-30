
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
        const building = buildingDiv.parentElement.classList[0];
        const workerType = workerDiv.closest('.worker').classList[1];
        let number = await addWorker(building, workerType);
        span.innerHTML = numFormat(number);
    });
});

document.querySelectorAll('.minus-button').forEach(button => {
    button.addEventListener('click', async () => {
        const workerDiv = button.parentElement;
        const span = workerDiv.querySelector('span');
        const buildingDiv = workerDiv.closest('.building')
        const building = buildingDiv.parentElement.classList[0];
        const workerType = workerDiv.closest('.worker').classList[1];
        let number = await subtractWorker(building, workerType);
        span.innerHTML = numFormat(number);
    });
});


async function addWorker(buildingType, resourceWorker){
    const response = await fetch('/api/' + buildingType + "/addWorker/" + resourceWorker,{method: 'POST'});
    const data = await response.json();
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
    setTimeout(() => {
        fetch('/api/' + buildType + '/buildFinish', {
            method: 'POST'
        });
    }, buildTime);
}

setInterval(production, 10000);

updateResourceData();
