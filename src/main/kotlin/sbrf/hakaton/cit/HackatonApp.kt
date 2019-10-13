package sbrf.hakaton.cit

import io.javalin.Javalin
import io.javalin.Javalin.log
import io.javalin.plugin.json.JavalinJackson
import io.javalin.plugin.openapi.annotations.ContentType
import sbrf.hakaton.cit.util.getProp
import sbrf.hakaton.cit.util.globalObjectMapper


fun main() {

    WebController().init(startServer())
    val requester = Requester()
    val get = requester.get("/data")
    log.info(get.third.component1().toString())

}

fun startServer(): Javalin = Javalin
    .create {
        it.apply {
            defaultContentType = ContentType.JSON
            JavalinJackson.configure(globalObjectMapper)
            enableDevLogging()
        }
    }
    .start(getProp("server.port", 7777).toInt())
