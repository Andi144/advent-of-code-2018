package util

object Util {

    fun getResource(path: String): String = javaClass.classLoader.getResource(path).readText()

    fun getResourceLines(path: String): List<String> = getResource(path).split(System.lineSeparator())

}