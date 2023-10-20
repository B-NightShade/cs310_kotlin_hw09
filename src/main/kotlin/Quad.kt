data class Quad(val title: String, val a:Double, val b:Double, val c:Double) {
    fun quadratic(a:Double, b:Double, c:Double):String{
        val valOne:Double = (-b + Math.sqrt((b*b)-4*a*c))/(2*a)
        val valTwo:Double = (-b - Math.sqrt((b*b)-4*a*c))/(2*a)
        val result:String
        if(valOne.isNaN() && valTwo.isNaN()){
            result = "(None, None)"
        }else if(valTwo.isNaN()) {
            result = "($valOne, None)"
        }else if(valOne.isNaN()){
            println("here")
            result = "(None, $valTwo)"
        }else {
            result = "($valOne, $valTwo)"
        }
        return result
    }

}