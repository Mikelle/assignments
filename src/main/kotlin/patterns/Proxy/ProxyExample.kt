package Proxy

/**
 * Created by Antropov Igor on 24.11.2015.
 */

interface IBalance {
    fun getAccountBalance(): String
}

public class Balance : IBalance {
    override fun getAccountBalance(): String {
        return "500"
    }
}

public class ProxyBalance : IBalance {
    private var realBalance: Balance? = null

    public fun authorization(name: String, password: String){
        if (name == "Bobby" && password == "qwerty")
            realBalance = Balance()
    }

    override fun getAccountBalance(): String {
        return realBalance?.getAccountBalance() ?: "You are not logged on"
    }
}

fun main(args: Array<String>) {
    var bobbyBalance = ProxyBalance()

    println(bobbyBalance.getAccountBalance())

    bobbyBalance.authorization("Bobby", "1234567890")
    println(bobbyBalance.getAccountBalance())

    bobbyBalance.authorization("Bobby", "qwerty")
    println(bobbyBalance.getAccountBalance())
}
