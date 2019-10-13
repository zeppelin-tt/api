package sbrf.hakaton.cit

import io.javalin.Javalin
import sbrf.hakaton.cit.domain.WebResponse
import kotlin.intArrayOf as iarr


class WebController {

    private val requester = Requester()

    fun init(connect: Javalin) {
        connect.get("/") { ctx ->
            ctx.result("Hello, Maxim!")
        }
        connect.get("/data") { ctx ->
            ctx.json(getData())
        }
//        connect.get("/run") { webController.run }
    }



    var run: () -> Unit = {
        requester.get("data")
    }

    private fun getData(): WebResponse {
        val edgesTest = arrayOf(
            iarr(0, 4, 3, 1, 0, 0, 0, 0, 0, 0),
            iarr(4, 0, 0, 6, 3, 0, 0, 0, 0, 0),
            iarr(3, 0, 0, 0, 10, 0, 0, 0, 0, 0),
            iarr(1, 6, 0, 0, 0, 8, 14, 0, 0, 0),
            iarr(0, 3, 10, 0, 0, 0, 0, 11, 0, 0),
            iarr(0, 0, 0, 8, 0, 0, 2, 4, 0, 0),
            iarr(0, 0, 0, 14, 0, 2, 0, 0, 1, 0),
            iarr(0, 0, 0, 0, 11, 4, 0, 0, 6, 3),
            iarr(0, 0, 0, 0, 0, 0, 1, 6, 0, 0),
            iarr(0, 0, 0, 0, 0, 0, 0, 3, 0, 0)
        )
        val directionEdgesTest = arrayOf(
            iarr(0, 4, 3, 1, 0, 0, 0, 0, 0, 0),
            iarr(0, 0, 0, 6, 3, 0, 0, 0, 0, 0),
            iarr(3, 0, 0, 0, 10, 0, 0, 0, 0, 0),
            iarr(1, 6, 0, 0, 0, 8, 14, 0, 0, 0),
            iarr(0, 3, 10, 0, 0, 0, 0, 11, 0, 0),
            iarr(0, 0, 0, 8, 0, 0, 2, 4, 0, 0),
            iarr(0, 0, 0, 14, 0, 2, 0, 0, 1, 0),
            iarr(0, 0, 0, 0, 11, 4, 0, 0, 6, 3),
            iarr(0, 0, 0, 0, 0, 0, 1, 6, 0, 0),
            iarr(0, 0, 0, 0, 0, 0, 0, 3, 0, 0)
        )
        return WebResponse(
            carCount = 5,
            minutes = 15,
            edges = edgesTest,
            directionEdges = directionEdgesTest
        )
    }


}