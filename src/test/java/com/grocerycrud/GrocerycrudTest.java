package com.grocerycrud;


import model.DesafioDois;
import model.DesafioUm;
import model.ModelGlobal;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Browser;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class GrocerycrudTest {

    DesafioUm desafioUm = new DesafioUm();
    DesafioDois desafioDois = new DesafioDois();
    ModelGlobal modelGlobal = new ModelGlobal();
    ChromeDriver navegator;
    Browser browse = new Browser();
    WebDriverWait wait;

    // ESSE METODO ABRE A PÁGINA NO CHROME
    public void openBrowser() {
        System.setProperty(browse.WEBCHROMEDRIVE, browse.PATHCHROME);
    }

    // METODO PARA PREENCHER CAMPOS
    public void preencheCampo(){
        // OS METODOS A SEGUIR MAPEIAM OS CAMPOS E JA PREENCHEM COM O TEXTO SOLICITADO
        //
        navegator.findElement(By.id(desafioUm.getIdName())).sendKeys(desafioUm.getName());
        navegator.findElement(By.id(desafioUm.getIdLastname())).sendKeys(desafioUm.getLastName());
        navegator.findElement(By.id(desafioUm.getIdContactFirstName())).sendKeys(desafioUm.getContactFirstName());
        navegator.findElement(By.id(desafioUm.getIdPhone())).sendKeys(desafioUm.getPhone());
        navegator.findElement(By.id(desafioUm.getIdAddressLine1())).sendKeys(desafioUm.getAddressLine1());
        navegator.findElement(By.id(desafioUm.getIdAddressLine2())).sendKeys(desafioUm.getAddressLine2());
        navegator.findElement(By.id(desafioUm.getIdCity())).sendKeys(desafioUm.getCity());
        navegator.findElement(By.id(desafioUm.getIdState())).sendKeys(desafioUm.getState());
        navegator.findElement(By.id(desafioUm.getIdPostalCode())).sendKeys(desafioUm.getPostalCode());
        navegator.findElement(By.id(desafioUm.getIdCountry())).sendKeys(desafioUm.getCountry());
        navegator.findElement(By.id(desafioUm.getIdFromEmployeer())).click();
        navegator.findElement(By.xpath(desafioUm.getXpathFromEmployeer())).click();
        navegator.findElement(By.id(desafioUm.getIdCreditLimit())).sendKeys(desafioUm.getCreditLimit());
    }

    public void addCostumer(){
        // MAPEIA COMBOBOX DO SELECT VERSION PARA SELECIONAR O ITEM DESEJADO DENTRO
        wait.until(ExpectedConditions.elementToBeClickable(By.id(modelGlobal.getIdCbSelectTheme())));
        WebElement selectVersion = navegator.findElement(By.id(modelGlobal.getIdCbSelectTheme()));
        Select select = new Select(selectVersion);
        select.selectByVisibleText(modelGlobal.getNameCbV4Theme());

        // MAPEIA O TEXTO LINK PARA ADICIONAR UM CLIENTE E CLICA NESSE TEXTO
        navegator.findElement(By.linkText(modelGlobal.getTxtBtnAddCostumer())).click();
    }


    @Test
    public void testDesafioUmHappyWay() {

        // CHAMA O MÉTODO PARA ABRIR A PÁGINA NO CHROME
        openBrowser();

        // CRIA O DRIVER DO CHROME WEB DRIVER
        navegator = new ChromeDriver();
        wait = new WebDriverWait(navegator, 10);

        // CHAMA A CONSTANTE COM URL DA PÁGINA QUE DEVE ACESSAR
        navegator.get(browse.URLPAGE);

        // DETERMINAR QUE IRÁ ESPERAR POR 5 SEGUNDO ABRIR UM MENU OU PAGE ANTES DE DAR TIMEOUT
        navegator.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // CHAME METODO PARA MAPEAR O AMBIENTE E CLICAR EM ADD COSTUMER
        addCostumer();

        // CHAMA METODO PREENCHE CAMPO
        preencheCampo();


        // AQUI É MAPEADO O MOTÃO SAVE PELO ID E LOGO É CLICADO NO MESMO
        //
        navegator.findElement(By.id(desafioUm.getIdBtnSave())).click();


        // ESPERAR O ELEMENTO APARECER EM TELA PARA UTILIZA-LO
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(desafioUm.getXpathSuccessMsg())));


        // É PEGO O TEXTO INFORMADO EM TELA DE SOCESSO NO CADASTRO PARA SER VALIDADO
        //
        String getMsg = navegator.findElement(By.xpath(desafioUm.getXpathSuccessMsg())).getText();
        Assert.assertEquals(desafioUm.getMsgSuccess(), getMsg);

        // NAVEGADOR É FECHADO
        navegator.quit();


    }

    @Test
    public void testDesafioDoisHappyWay() throws InterruptedException {

        // CHAMA O MÉTODO PARA ABRIR A PÁGINA NO CHROME
        openBrowser();

        // CRIA O DRIVER DO CHROME WEB DRIVER
        navegator = new ChromeDriver();
        wait = new WebDriverWait(navegator, 5);

        // CHAMA A CONSTANTE COM URL DA PÁGINA QUE DEVE ACESSAR
        navegator.get(browse.URLPAGE);

        // DETERMINAR QUE IRÁ ESPERAR POR 5 SEGUNDO ABRIR UM MENU OU PAGE ANTES DE DAR TIMEOUT
        navegator.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // CHAME METODO PARA MAPEAR O AMBIENTE E CLICAR EM ADD COSTUMER
        addCostumer();

        // CHAMA METODO PREENCHE CAMPO
        preencheCampo();


        // AQUI É MAPEADO O MOTÃO SAVE PELO ID E LOGO É CLICADO NO MESMO
        //
        navegator.findElement(By.id(desafioUm.getIdBtnSave())).click();


        // ESPERAR O ELEMENTO APARECER EM TELA PARA UTILIZA-LO
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(desafioUm.getXpathSuccessMsg())));


        // É PEGO O TEXTO INFORMADO EM TELA DE SOCESSO NO CADASTRO PARA SER VALIDADO
        //
        String getMsg = navegator.findElement(By.xpath(desafioUm.getXpathSuccessMsg())).getText();
        Assert.assertEquals(desafioUm.getMsgSuccess(), getMsg);


        // CLICA NO LINK, VOLTA PARA INICIAL
        navegator.findElement(By.linkText(desafioDois.getTxtSaveAndBack())).click();

        // PEGA O XPACH DO LABEL PARA PESQUISAR PELO NOME DO CADASTRO
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(desafioDois.getXpathSearchName())));
        navegator.findElement(By.xpath(desafioDois.getXpathSearchName()))
                .sendKeys(desafioDois.getTxtTextCRUD());

        // VERIFICAR SE JA ENCONTROU O RESULTADO NA PESQUISA ANTERIOR, CASO NÃO ESPERA 2 SEGUNDOS (DELAY PAGINA)
        if (!navegator.findElement(By.xpath(desafioDois.getXpathResultSearchname())).getText().equals(desafioDois.getTxtTextCRUD())) {
            Thread.sleep(2000);
        }

        // CLICA NO CHECKBOX E LOGO APÓS ESPERA 2,5 SEGUNDOS, PELO DELAY DE ATUALIZAR PAGINA
        navegator.findElement(By.xpath(desafioDois.getXpathActionCheckBox())).click();
        Thread.sleep(2500);

        // APÓS ESPERA VERIFICA NOVAMENTE SE O CHECKBOX ESTÁ SELECIONADO
        // CASO NÃO, ELE SELECIONA NOVAMENTE (PAGINA ESTA DANDO UMA ATUALIZADA
        // NO FORM E DESMARCADO CHECKBOX
        if (!navegator.findElement(By.xpath(desafioDois.getXpathActionCheckBox())).isSelected())
            navegator.findElement(By.xpath(desafioDois.getXpathActionCheckBox())).click();

        // CLICA NO BOTÃO (LINK) DE DELETE
        navegator.findElement(By.linkText(desafioDois.getBtnLinkDelete())).click();

        // PEGA MSG DO ALERT
        String alertSing = navegator.findElement(By.xpath(desafioDois.getXpathAlertSing())).getText();
        String alertPlu = navegator.findElement(By.xpath(desafioDois.getXpathAlertPlu())).getText();

        // PEGA QUANTIDADE DE ITENS SELECIONADOS PARA SER DELETADO
        String qtdDel = navegator.findElement(By.xpath(desafioDois.getXpathQtdItensDelete())).getText();

        // COMPARA SE A MSG DO ALERT ESTÁ CORRETA
        // PARA VERIFICAR SE VAI SER DELETADO 1 OU MAIS ITENS
        if (alertSing.equals(desafioDois.getTxtAlertSing1())) {
            Assert.assertEquals(desafioDois.getTxtAlertSing1(), alertSing);
        } else {
            Assert.assertEquals(desafioDois.getTxtAlertPlural1() + qtdDel + desafioDois.getTxtAlertPlural2(), alertPlu);
        }

        // CASO MSG CORRETA CLICA NO BOTÃO DELETE DO ALERT
        navegator.findElement(By.xpath(desafioDois.getXpathBtnDeleteAlert())).click();

        // ESPERA O ELEMENTO APARECER EM TELA PARA VALIDA-LO
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(desafioDois.getXpathMsgConfirmDelete())));

        // PEGA TEXTO DA MSG DE CONFIRMAÇÃO EXCLUSÃO
        String text = navegator.findElement(By.xpath(desafioDois.getXpathMsgConfirmDelete())).getText();

        // COMPARA SE A MSG DA CONFIRMAÇÃO ESTÁ CORRETA
        Assert.assertEquals(desafioDois.getMSGCONFIRMADELETE(), text);

        // FECHA NAVEGADOR
        navegator.quit();


    }
}