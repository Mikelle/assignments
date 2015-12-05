package patterns

/** Определим общий для RealImage и ProxyImage интерфейс,
 * так что класс ProxyImage можно использовать везде, где ожидается RealImage
 */
internal interface Image {
    public fun display()
}

/** Определяет реальный объект, представленный заместителем */
internal class RealImage(private val fileName: String) : Image {

    init {
        loadFromDisk(fileName)
    }

    override public fun display() {
        println("Displaying " + fileName + "\n")
    }

    private fun loadFromDisk(fileName: String) {
        println("Loading " + fileName)
    }
}

/** Хранит ссылку, которая позволяет заместителю обратиться к реальному
 * субъекту. Объект класса ProxyImage может обращаться к объекту класса
 * Image, если интерфейсы классов RealImage и Image одинаковы.
 * Предоставляет интерфейс, идентичный интерфейсу Image,
 * так что заместитель всегда может быть подставлен вместо реального субъекта.
 * Контролирует доступ к реальному субъекту
 */
internal class ProxyImage(private val fileName: String) : Image {

    private var realImage: RealImage? = null

    override public fun display() {
        if (realImage == null) {
            realImage = RealImage(fileName)
        }
        realImage?.display()
    }
}

internal fun main(args: Array<String>) {
    val image = ProxyImage("test.jpg")

    //изображение будет загружено
    image.display()

    //изображение не будет загружено
    image.display()
}
