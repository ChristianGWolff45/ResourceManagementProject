
const arrowButton = document.getElementsByClassName('arrow-button')[0];
const resource = document.getElementById('resources');
const resourceArrow = function() {
    console.log(arrowButton.innerHTML);
    if (arrowButton.innerHTML === '▼') {
        arrowButton.innerHTML = '▲';
        resource.style.height = 'auto';
    } else {
        arrowButton.innerHTML = '▼';
        resource.style.height = '50px';
    }
}
arrowButton.onclick = resourceArrow;


document.querySelectorAll('.plus-button').forEach(button => {
    button.addEventListener('click', () => {
        const workerDiv = button.parentElement;
        const span = workerDiv.querySelector('span');
        let number = parseInt(span.textContent);
        number++;
        span.innerHTML = numFormat(number);
    });
});

document.querySelectorAll('.minus-button').forEach(button => {
    button.addEventListener('click', () => {
        const workerDiv = button.parentElement;
        const span = workerDiv.querySelector('span');
        let number = parseInt(span.textContent);
        number--;
        span.innerHTML = numFormat(number);
    });
});

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



document.querySelectorAll('#build img').forEach(build => {
    build.addEventListener('click', () =>{
        const buildType = build.id;
        console.log(buildType);
    })
})


async function updateLumbermillUI() {
    const response = await fetch('/api/LM');
    const data = await response.json();

    document.querySelector('.lumbermill .count').innerText = numFormat(data.buildingCount);
    document.querySelector('.woodWorker span').innerText = numFormat(data.maxWorkers);
}

async function updateResourceData() {
    const response = await fetch('/api/resourceData')
    const data = await response.json();
    console.log(data);
    Object.entries(data).forEach(([key, value]) => {
        let el = (document.querySelector('.' + key + '-amount'))
        if(el)
            el.innerText = numFormat(value);
    });
}

// Call once immediately, then every 10 seconds
updateResourceData();
