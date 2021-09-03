module com.tsayun.obj_3d_reader {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires javafx.graphics;


    opens com.tsayun.obj_3d_reader to javafx.fxml;
    exports com.tsayun.obj_3d_reader;
}