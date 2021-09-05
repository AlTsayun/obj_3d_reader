package com.tsayun.obj_3d_reader

import com.tsayun.obj_3d_reader.modelProvider.ModelProvider
import com.tsayun.obj_3d_reader.modelProvider.impl.ObjModelProvider
import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.scene.shape.Sphere
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val modelProvider: ModelProvider = ObjModelProvider()
        val model = modelProvider.model
        val group = Group()
        group.children.add(model)
        val scene = Scene(group, 800.0, 600.0)
        scene.fill = Color.SILVER
        stage.title = "obj 3d reader"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}