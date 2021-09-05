package com.tsayun.obj_3d_reader.model

fun verify(condition: Boolean, exceptionSupplier: () -> Exception) {
    if (!condition) throw exceptionSupplier()
}

fun forbid(condition: Boolean, exceptionSupplier: () -> Exception) {
    if (condition) throw exceptionSupplier()
}