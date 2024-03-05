let estrellas = document.getElementById('estrellas');
let luna = document.getElementById('luna');
let mountains_behind = document.getElementById('mountains_behind');
let texto = document.getElementById('texto');
let boton = document.getElementById('boton');
let mountains_front = document.getElementById('mountains_front');
let header = document.querySelector('header');



window.addEventListener('scroll',function (){
    let value = window.scrollY;
    estrellas.style.left =  0 + 'px';
    luna.style.top = value * 1.05 + 'px';
    mountains_behind.style.top = value * 0.5 + 'px';
    mountains_front.style.top = value * 0 + 'px';
    texto.style.marginRight = value * 3.5 + 'px';
    texto.style.marginTop = value * 1.5 + 'px';
    boton.style.marginTop = value * 1.5 + 'px';
    header.style.top = value * 0.5 + 'px';
})

    let imgBx = document.querySelectorAll('.imgBx');
    let contentBx = document.querySelectorAll('.contentBx');

    for (var x = 0; x < imgBx.length; x++) {
    imgBx[x].addEventListener('mouseover', function () {
        for (var j = 0; j < contentBx.length; j++) {
            contentBx[j].className = 'contentBx';
        }
        document.getElementById(this.dataset.id).className = 'contentBx active';

        for (var k = 0; k < imgBx.length; k++) {
            imgBx[k].className = 'imgBx';
        }
        this.className = 'imgBx active';
    });
}
