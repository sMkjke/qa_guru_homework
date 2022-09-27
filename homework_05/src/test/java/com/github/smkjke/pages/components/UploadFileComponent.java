package com.github.smkjke.pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class UploadFileComponent {

    public UploadFileComponent uploadFile(File file) {
        $x(".//input[@id='uploadPicture']").uploadFile(file);
        return this;
    }

}
