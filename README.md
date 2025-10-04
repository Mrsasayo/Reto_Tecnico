```markdown
# Reto Técnico de Automatización - SQA

Este repositorio contiene la solución a un reto técnico diseñado para evaluar y validar conocimientos en la automatización de pruebas web utilizando Serenity BDD, Cucumber y Java con Maven.

## ⚙️ Guía de Configuración y Ejecución

Siga los siguientes pasos para configurar y ejecutar las pruebas en su entorno local.

### 1. Clonar el Repositorio

Primero, clone este repositorio en su máquina local utilizando el siguiente comando:

```bash
git clone https://github.com/Mrsasayo/Reto_Tecnico.git
```

### 2. Ejecutar las Pruebas

Una vez clonado el proyecto, navegue hasta la raíz del directorio y ejecute el siguiente comando de Maven:

```bash
mvn clean verify

```

**¿Qué hace este comando?**

- **`clean`**: Limpia cualquier compilación anterior y elimina la carpeta `target` si existiera.
- **`verify`**: Ejecuta todo el ciclo de vida de Maven. Esto incluye:
    - Descargar todas las dependencias definidas en el `pom.xml`.
    - Compilar el código fuente del proyecto.
    - Ejecutar las pruebas automatizadas.
    - **Generar la carpeta `target`** con los reportes de Serenity BDD.

---

## 🏗️ Estructura del Proyecto

A continuación, se describe la función de los archivos y directorios más importantes del proyecto.

- **`pom.xml`**
    
    > Este es el archivo de configuración principal de Maven (Project Object Model). Define todas las dependencias necesarias para el proyecto (Serenity, Cucumber, Selenium, JUnit), así como los plugins que gestionan la compilación y la ejecución de las pruebas.
    > 
- **`serenity.conf`**
    
    > Archivo de configuración de Serenity BDD. En este proyecto, se utiliza para especificar las características del WebDriver, indicando que se usará Chrome y que el driver correspondiente debe ser descargado automáticamente (autodownload = true).
    > 
- **`src/test/resources/features/ReservaCita.feature`**
    
    > Este es el archivo de características (Feature File) escrito en Gherkin. Describe los escenarios de prueba en un lenguaje natural y legible (Given, When, Then), sirviendo como documentación viva y como base para la automatización.
    > 
- **`src/test/java/.../pages/DatepickerPage.java`**
    
    > Implementación del patrón Page Object Model (POM). Esta clase encapsula los localizadores (WebElements) y los métodos para interactuar con la página de JQuery Datepicker. La lógica de cómo encontrar y manipular los elementos de la página reside aquí, manteniendo las pruebas limpias.
    > 
- **`src/test/java/.../stepdefinitions/DatepickerSteps.java`**
    
    > La clase de "Step Definitions". Actúa como el "pegamento" (glue) que conecta los pasos en lenguaje natural del archivo .feature con las acciones concretas implementadas en el Page Object (DatepickerPage.java).
    > 
- **`src/test/java/.../runners/TestRunner.java`**
    
    > Esta clase es el punto de entrada para la ejecución de las pruebas. Utiliza JUnit para correr Cucumber, e indica dónde se encuentran los archivos .feature y las clases "glue" (step definitions).
    > 
- **`target/`**
    
    > Importante: Esta carpeta es autogenerada por Maven durante la ejecución del comando mvn clean verify. No se incluye en el repositorio. Aquí es donde se guardan todos los resultados de la compilación, pero lo más importante es que contiene el directorio site/serenity/, donde se encuentran los reportes HTML interactivos con la evidencia de las pruebas ejecutadas.
    >