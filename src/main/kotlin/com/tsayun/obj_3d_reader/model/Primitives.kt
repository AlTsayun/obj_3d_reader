package com.tsayun.obj_3d_reader.model

data class Vertex(val x: Double, val y: Double, val z: Double, val weight: Double = 1.0) {
    init {
        verify(weight > 0) { VertexWeightOutOfBoundsException(weight) }
    }
}

class VertexWeightOutOfBoundsException(val w: Double) : RuntimeException()

// todo: check if VertexNormal can be unit normal
data class VertexNormal(val x: Double, val y: Double, val z: Double)

data class TextureVertex(
    val horizontalDirection: Double,
    val verticalDirection: Double = 0.0,
    val depth: Double = 0.0
) {
    init {
        forbid(horizontalDirection < 0 && horizontalDirection > 1) {
            TextureVertexHorizontalDirectionOutOfBoundsException(horizontalDirection)
        }
        forbid(verticalDirection < 0 && verticalDirection > 1) {
            TextureVertexVerticalDirectionOutOfBoundsException(verticalDirection)
        }
        forbid(depth < 0 && depth > 1) {
            TextureVertexDepthOutOfBoundsException(depth)
        }
    }
}

class TextureVertexHorizontalDirectionOutOfBoundsException(val hD: Double) : RuntimeException()
class TextureVertexVerticalDirectionOutOfBoundsException(val hV: Double) : RuntimeException()
class TextureVertexDepthOutOfBoundsException(val d: Double) : RuntimeException()

//todo: check if need weight > 0 for ParameterSpaceVertex
data class ParameterSpaceVertex(val x: Double, val y: Double = 0.0, val weight: Double = 1.0)

data class CurveSurfaceType(val isRational: Boolean, val type:CurveSurfaceTypeType)

enum class CurveSurfaceTypeType{
    BASIS_MATRIX,
    BEZIER,
    B_SPINE,
    CARDINAL,
    TAYLOR
}



