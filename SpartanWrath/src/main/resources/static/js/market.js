let cartItems = [];

function addToCart(productName, price) {
    // Buscar si el producto ya está en el carrito
    const existingItem = cartItems.find(item => item.name === productName);

    if (existingItem) {
        // Si el producto ya está en el carrito, incrementar el contador de unidades
        existingItem.quantity++;
    } else {
        // Si el producto no está en el carrito, agregarlo con una unidad
        cartItems.push({ name: productName, price: price, quantity: 1 });
    }

    // Actualizar la cantidad de productos en el carrito
    updateCartCount();
    // Actualizar la visualización del carrito
    showCart();
}

function updateCartCount() {
    const cartCount = document.getElementById('cart-count');
    cartCount.innerText = cartItems.reduce((total, item) => total + item.quantity, 0);
}

function showCart() {
    const cart = document.getElementById('cart');
    const cartItemsList = document.getElementById('cart-items');
    cartItemsList.innerHTML = ''; // Limpiar la lista antes de agregar los elementos

    if (cartItems.length === 0) {
        const emptyCartMsg = document.createElement('p');
        emptyCartMsg.textContent = 'El carrito está vacío';
        cartItemsList.appendChild(emptyCartMsg);
    } else {
        cartItems.forEach(item => {
            const li = document.createElement('li');
            const quantitySpan = document.createElement('span');
            const nameSpan = document.createElement('span');
            const priceSpan = document.createElement('span');
            const addButton = document.createElement('button');
            const removeButton = document.createElement('button');

            quantitySpan.textContent = `${item.quantity} x ⚫ ${item.name}:`;
            nameSpan.textContent = ''; // Placeholder para el nombre del producto
            priceSpan.textContent = `${(item.price * item.quantity).toFixed(2)}€ `;
            addButton.textContent = '+';
            removeButton.textContent = '-';

            // Añadir espacio entre el precio y los botones
            const space = document.createTextNode(' ');

            addButton.addEventListener('click', () => {
                item.quantity++;
                quantitySpan.textContent = `${item.quantity} x ⚫ ${item.name}:`;
                updateCartCount();
                showCart();
            });

            removeButton.addEventListener('click', () => {
                if (item.quantity > 1) {
                    item.quantity--;
                    quantitySpan.textContent = `${item.quantity} x ⚫ ${item.name}:`;
                } else {
                    // Si solo hay una unidad y se hace clic en "-", eliminar el producto del carrito
                    const index = cartItems.indexOf(item);
                    if (index !== -1) {
                        cartItems.splice(index, 1);
                    }
                    showCart();
                }
                updateCartCount();
            });

            li.appendChild(quantitySpan);
            li.appendChild(nameSpan);
            li.appendChild(priceSpan);
            li.appendChild(space); // Agregar espacio
            li.appendChild(addButton);
            li.appendChild(removeButton);

            cartItemsList.appendChild(li);
        });
    }

    cart.classList.toggle('hide');
}








