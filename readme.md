# SauceDemo E2E con SerenityBDD y Screenplay

Este proyecto implementa una prueba E2E automatizada para el flujo de compra en [SauceDemo](https://www.saucedemo.com/) usando **SerenityBDD con Screenplay Pattern** y **Cucumber** para la generación de reportes.

## 📌 Prerrequisitos

Asegúrate de tener instalado y configurado lo siguiente en tu máquina local:

- **Sistema Operativo**: Windows 10 (probado)
- **IDE**: IntelliJ IDEA (2023.1 o superior)
- **Gradle**: 7.6.1 (el wrapper incluido en el proyecto puede ser usado)
- **JDK**: 17.0.16 (definido en la variable de entorno `JAVA_HOME`)
- **Google Chrome**: Versión 140 (o la última estable)
- **Git**: instalado y configurado

⚠️ Importante: El proyecto utiliza **WebDriverManager** integrado en Serenity (`webdriver.autodownload=true`) para descargar el driver de Chrome automáticamente según la versión del navegador.

## ⚙️ Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/saucedemo-e2e-serenity.git
   cd saucedemo-e2e-serenity
   ```

2. Verifica dependencias (usando el wrapper de Gradle incluido):
   ```bash
   ./gradlew clean build --refresh-dependencies
   ```

Esto descargará todas las dependencias necesarias.

## ▶️ Ejecución de las pruebas

1. Para ejecutar todas las pruebas:
   ```bash
   ./gradlew test
   ```

2. Para ejecutar solo escenarios con la etiqueta `@purchase`:
   ```bash
   ./gradlew test -Dcucumber.filter.tags=@purchase
   ```

3. Los reportes se generan automáticamente en:
   ```
   build/reports/tests/test/index.html
   build/reports/serenity/index.html
   target/site/serenity/index.html
   ```

Abre cualquiera de estos archivos en un navegador para visualizar los resultados. El reporte en `target/site/serenity/index.html` es el más completo: incluye el detalle de los escenarios, pasos ejecutados y capturas de pantalla.

## 📂 Estructura del Proyecto

```
src
 └── test
     ├── java
     │   └── com.santiago
     │       ├── glue/               # Step Definitions
     │       ├── questions/          # Preguntas (Assertions)
     │       ├── tasks/              # Tasks (acciones Screenplay)
     │       └── userinterfaces/     # Elementos de la UI (Targets)
     └── resources
         ├── features/               # Archivos .feature (Cucumber)
         │   └── purchase.feature
         └── data/                   # Archivos JSON para test data
             ├── products.json
             └── checkout-user.json
```

## 📑 Datos de prueba

- **Usuario:** `standard_user`
- **Password:** `secret_sauce`

- **Archivo `products.json`**
  ```json
  {
    "products": [
      "Sauce Labs Backpack",
      "Sauce Labs Onesie"
    ]
  }
  ```

- **Archivo `checkout-user.json`**
  ```json
  {
    "firstName": "Juan",
    "lastName": "Pérez",
    "postalCode": "170101"
  }
  ```

## 📝 Instrucciones adicionales

- El archivo `serenity.conf` ya está configurado para usar Chrome con los parámetros necesarios.
- En caso de errores con el navegador, asegúrate de que Chrome esté actualizado y que el `chromedriver` descargado sea compatible (Serenity lo maneja automáticamente).
- Para eliminar alertas inesperadas durante la ejecución, se configuró `unhandledPromptBehaviour = dismiss`, lo que garantiza que no se interrumpa el flujo.

## 📊 Reportes

- **Reporte estándar de Gradle:**
  - `build/reports/tests/test/index.html`
- **Reporte enriquecido de Serenity (build):**
  - `build/reports/serenity/index.html`
- **Reporte completo de Serenity (target):**
  - `target/site/serenity/index.html`

El reporte en `target/site/serenity/index.html` es el recomendado, ya que incluye capturas de pantalla en cada paso, métricas de ejecución y detalles de los escenarios.

## 📌 Conclusiones

- La prueba E2E automatiza correctamente el flujo de compra en SauceDemo.
- Se implementó el patrón **Screenplay** para un diseño modular, reutilizable y mantenible.
- Los datos de prueba se cargan dinámicamente desde archivos JSON.
- Los reportes de Serenity proveen trazabilidad completa y visual, con capturas en cada paso.

---

👨‍💻 Autor: **Santiago Bejarano**  
📅 Fecha: Septiembre 2025

