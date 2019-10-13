package sbrf.hakaton.cit.domain

data class WebResponse (
    var carCount: Int,
    var minutes: Int,
    var edges: Array<IntArray>,
    var directionEdges: Array<IntArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WebResponse

        if (carCount != other.carCount) return false
        if (minutes != other.minutes) return false
        if (!edges.contentDeepEquals(other.edges)) return false
        if (!directionEdges.contentDeepEquals(other.directionEdges)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = carCount
        result = 31 * result + minutes
        result = 31 * result + edges.contentDeepHashCode()
        result = 31 * result + directionEdges.contentDeepHashCode()
        return result
    }
}