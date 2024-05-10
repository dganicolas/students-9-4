package console

import Product

interface Iconsola {
    fun showMessage(message: String, lineBreak: Boolean=true)
    fun show(productsList: List<Product>?,message: String = "All users:")
}