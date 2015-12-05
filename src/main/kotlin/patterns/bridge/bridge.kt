// Example for pattern "Bridge"
// Alekseev Aleksei, group 271

package patterns.bridge

import java.util.*

/* Abstraction */
public abstract class Image(internal var imageImp: ImageImp) {
    init {
        this.imageImp = imageImp
    }
    public fun getFormat() {
        imageImp.format()
    }
}

/* Implementor */
public class Photo(imageImp: ImageImp) : Image(imageImp)

public interface ImageImp {
    public fun format()
}

/* ConcreteImplementor */
internal class Png : ImageImp {
    public override fun format() {
        println("Image format: Png")
    }
}

/* ConcreteImplementor */
internal class Jpg : ImageImp {
    public override fun format() {
        println("Image format: Jpg")
    }
}

/* Client */
fun main(args : Array<String>) {
    val album = ArrayList<Photo>()
    album.add(Photo(Png()))
    album.add(Photo(Jpg()))
    for (photo in album) {photo.getFormat()}
}
