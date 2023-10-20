import java.io.File
import java.lang.NumberFormatException

fun main(args: Array<String>) {
    print("Enter a file: ")
    var fileName = readLine()
    var file = File(fileName)

    if (!file.exists()) {
        println("Error opening file: $fileName")
        System.exit(1)
    } else {
        var count = file.readLines().size
        val quadratics = arrayOfNulls<Quad?>(count)
        var index = 0
        file.forEachLine {
            var splitLine = it.split(' ')
            if((splitLine.size) <= 4 ){
                try {
                    val quadratic = Quad(splitLine[0], splitLine[1].toDouble(), splitLine[2].toDouble(), splitLine[3].toDouble())
                    quadratics[index] = quadratic
                    index++
                }catch(e: NumberFormatException){
                    println("${index +1}: NumberFormatException")
                    quadratics[index] = null
                    index++
                }catch(e: IndexOutOfBoundsException) {
                    println("${index + 1}: IndexOutOfBoundsException")
                    quadratics[index] = null
                    index++
                }
            }
            else{
                println("${index + 1}: too many elements on line correct format: \"title a b c\" ")
                quadratics[index] = null
                index++
            }
        }
        println("===RESULTS===")
        for(q in quadratics.indices){
            var quad = quadratics[q]?.quadratic(quadratics[q]!!.a, quadratics[q]!!.b, quadratics[q]!!.c)
            when(quad){
                null-> println("${q+1}: BAD INPUT")
                else-> println("${q+1}: ${quadratics[q]?.title} $quad")
            }
        }
    }
}

