package console

import Product

class Consola : Iconsola {

    override fun showMessage(message:String, lineBreak:Boolean){
        if(lineBreak) println(message)
        else print(message)
    }

    override fun show(productsList: List<Product>?, message: String){
        if(productsList != null){
            if(productsList.isNotEmpty()){
                showMessage(message)
                productsList.forEachIndexed { index, userEntity ->
                    showMessage("\t${index+1}. $userEntity")
                }
            }else{
                showMessage("No Users Found")
            }
        }

    }
}