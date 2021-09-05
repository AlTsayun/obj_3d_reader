package com.tsayun.obj_3d_reader.model

data class VertexTriplet(
    val geometricVertex: Vertex,
    val textureVertex: TextureVertex? = null,
    val vertexNormal: VertexNormal? = null
)

data class VertexDoublet(val geometricVertex: Vertex, val textureVertex: TextureVertex? = null)

data class Point(val vertex: Vertex)

data class Line(val vertexes: List<VertexDoublet>) {
    init {
        verify(vertexes.size > 1) { LineVertexesCountTooLowException(vertexes) }
        for (i in 1..vertexes.size) {
            verify((vertexes[i - 1].textureVertex == null) == (vertexes[i].textureVertex == null)) {
                LineVertexesNotConsistentException(vertexes)
            }
        }
    }
}

class LineVertexesCountTooLowException(val vertexes: List<VertexDoublet>) : RuntimeException()
class LineVertexesNotConsistentException(val vertexes: List<VertexDoublet>) : RuntimeException()

//todo: Face: if vertex normals are assigned, they should point in the general direction of the surface normal
//todo: If a face has a texture map assigned to it and no texture vertices are assigned in the f statement, the texture map is ignored when the element is rendered.
data class Face(val vertexes: List<VertexTriplet>){
    init {
        for (i in 1..vertexes.size) {
            verify((vertexes[i - 1].textureVertex == null) == (vertexes[i].textureVertex == null)) {
                FaceVertexesNotConsistentException(vertexes)
            }
            verify((vertexes[i - 1].vertexNormal == null) == (vertexes[i].vertexNormal == null)) {
                FaceVertexesNotConsistentException(vertexes)
            }
        }
    }
}

class FaceVertexesNotConsistentException(val vertexes: List<VertexTriplet>) : RuntimeException()

data class Curve()
data class Curve2D()
data class Surface()
