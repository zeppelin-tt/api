package sbrf.hakaton.cit

import com.github.kittinunf.fuel.core.ResponseResultOf
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.jackson.responseObject
import sbrf.hakaton.cit.domain.WebResponse
import sbrf.hakaton.cit.util.getProp
import sbrf.hakaton.cit.util.globalObjectMapper

class Requester {

    companion object {
        val address = getProp("server.url", "http://localhost:7777")
    }

    internal fun get(path: String): ResponseResultOf<WebResponse> {
        return "$address$path".httpGet().responseObject(globalObjectMapper)
    }

}
