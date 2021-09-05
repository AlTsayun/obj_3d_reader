package com.tsayun.obj_3d_reader.modelProvider.impl

import com.tsayun.obj_3d_reader.modelProvider.ModelProvider
import javafx.scene.Node
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.effect.Light
import javafx.scene.paint.Color
import java.awt.Graphics

data class DoublePoint(val x: Double, val y: Double)

class ObjModelProvider(val gc: GraphicsContext) : ModelProvider{
    val canvas = Canvas(500.0, 500.0)

    init {
        gc.apply {
            fill = Color.BLACK
            stroke = Color.RED
            lineWidth = 1.0
            strokePolygon(listOf(DoublePoint(0.0, 0.0), DoublePoint(50.0, 0.0), DoublePoint(50.0, 50.0)))
            strokeLine(0.0, 0.0, 50.0, 50.0)
        }
    }
}

fun GraphicsContext.strokePolygon(points: List<DoublePoint>) {
    strokePolygon(points.map { it.x }.toDoubleArray(), points.map { it.y }.toDoubleArray(), points.size)
}