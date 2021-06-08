package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ModelGlobal {

    private String idCbSelectTheme = "switch-version-select";
    private String nameCbV4Theme = "Bootstrap V4 Theme";
    private String txtBtnAddCostumer = "Add Customer";

    public String getIdCbSelectTheme() {
        return idCbSelectTheme;
    }

    public String getNameCbV4Theme() {
        return nameCbV4Theme;
    }

    public String getTxtBtnAddCostumer() {
        return txtBtnAddCostumer;
    }
}
