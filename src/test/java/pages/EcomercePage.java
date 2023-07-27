package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcomercePage {
    WebDriver driver;
    public EcomercePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarAplicacao(){
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }

    public void preencherUsuario(String usuario){
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys(usuario);
    }

    public void preencherSenha(String senha){
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys(senha);
    }

    public void clicarEntrar(){
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
    }

    public void selecionarProdutoStylish() throws InterruptedException {
        driver.findElement(By.xpath("//li/a[contains(text(), 'Products')]\n")).click();

        int tempoMaximoEspera = 10;
        WebElement element = new WebDriverWait(driver, tempoMaximoEspera)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
        element.sendKeys("Stylish Dress");

        driver.findElement(By.id("submit_search")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,10000)");
        Thread.sleep(2000);

        WebElement linkElement = driver.findElement(By.xpath("//a[text()='View Product']"));
        linkElement.click();
        Thread.sleep(2000);
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("3");
    }

    public void selecionarProdutoBeautiful() throws InterruptedException {
        driver.findElement(By.xpath("//li/a[contains(text(), 'Products')]\n")).click();

        int tempoMaximoEspera = 10;
        WebElement element = new WebDriverWait(driver, tempoMaximoEspera)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
        element.sendKeys("Beautiful");

        driver.findElement(By.id("submit_search")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,10000)");
        Thread.sleep(2000);

        WebElement linkElement = driver.findElement(By.xpath("//a[text()='View Product']"));
        linkElement.click();
        Thread.sleep(2000);
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("2");
    }
    public void selecionarProdutoTshirt() throws InterruptedException {
        driver.findElement(By.xpath("//li/a[contains(text(), 'Products')]\n")).click();

        int tempoMaximoEspera = 10;
        WebElement element = new WebDriverWait(driver, tempoMaximoEspera)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
        element.sendKeys("Men Tshirt");

        driver.findElement(By.id("submit_search")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,10000)");
        Thread.sleep(2000);

        WebElement linkElement = driver.findElement(By.xpath("//a[text()='View Product']"));
        linkElement.click();
        Thread.sleep(2000);
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("1");
    }

    public void adicionarItemCarrinho(){
        WebElement botaoAddCart = driver.findElement(By.xpath("//button[contains(., 'Add to cart')]\n"));
        botaoAddCart.click();

        WebElement mensagemProdAdc = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[1]"));
        String textoDoElementoMensagem = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", mensagemProdAdc);
        Assert.assertEquals("Your product has been added to cart.", textoDoElementoMensagem);

        WebElement botaoViewCart = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a"));
        // Use JavaScript Executor para remover o estilo "display: none;" do botão
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", botaoViewCart);

        // Aguardand um pequeno intervalo para garantir que o botão seja exibido
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Agora você pode clicar no botão
        botaoViewCart.click();
    }

    public void verificarItemStylish(){
        WebElement produtoStylish = driver.findElement(By.xpath("//*[@id=\"product-4\"]/td[4]/button"));
        String itemStylish = produtoStylish.getText();
        Assert.assertEquals("3", itemStylish);
    }
    public void verificarBeautiful(){
        WebElement produtoBeautiful = driver.findElement(By.xpath("//*[@id=\"product-41\"]/td[4]/button"));
        String itemBeautiful = produtoBeautiful.getText();
        Assert.assertEquals("2", itemBeautiful);
    }
    public void verificarTshirt(){
        WebElement produtoTshirt= driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[4]/button"));
        String itemTshirt = produtoTshirt.getText();
        Assert.assertEquals("1", itemTshirt);
    }
}
