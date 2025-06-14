
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