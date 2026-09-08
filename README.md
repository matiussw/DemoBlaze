# DemoBlaze Tuya

Suite de pruebas automatizadas End-to-End (E2E) para el sitio de práctica de e-commerce [demoblaze.com](https://www.demoblaze.com), construida con **Serenity BDD**, **Cucumber** y el patrón **Screenplay**.

## Descripción

Este proyecto valida flujos funcionales del sitio DemoBlaze mediante escenarios escritos en Gherkin (en español) y ejecutados con Selenium WebDriver sobre Google Chrome. Actualmente cubre:

- **Listado de productos por categoría:** el usuario navega a la categoría *Laptops* y se valida que el sistema muestre los productos filtrados con su respectiva descripción y precio.
- **Login y selección de producto:** el usuario inicia sesión con credenciales de prueba, navega a la categoría *Laptops*, selecciona un producto y se valida que la página del producto cargue correctamente mostrando el botón **Add to cart**.

## Stack tecnológico

| Componente | Detalle |
|---|---|
| Lenguaje | Java |
| Build tool | Gradle (con Gradle Wrapper) |
| Framework BDD | [Serenity BDD](https://serenity-bdd.github.io/) — plugin `net.serenity-bdd.aggregator` v2.3.12, `serenity-core` v3.0.5 |
| Integración BDD | Serenity + Cucumber 6 (`serenity-cucumber6`) |
| Patrón de diseño | Screenplay (`serenity-screenplay-rest`) — Actors, Tasks, Questions, Interactions y Targets |
| Automatización web | Selenium WebDriver (vía Serenity), driver `chromedriver.exe` |
| Test runner | JUnit 4.13.1 (`serenity-junit`) |
| Otras librerías | `rest-assured` / `json-schema-validator`, `fillo`, `slf4j` |

## Estructura del proyecto

```
DemoBlaze/
├── build.gradle                 # Dependencias y configuración de Gradle/Serenity
├── settings.gradle               # Nombre del proyecto raíz (DemoBlazeTuya)
├── serenity.properties           # Configuración de Serenity/WebDriver (Chrome)
├── chromedriver.exe              # Driver de Chrome usado en la ejecución
├── gradlew / gradlew.bat         # Gradle Wrapper
└── src
    ├── main/java/co/com/tuya/certifications/demoblazetuya
    │   ├── iteractions/          # Interacciones reutilizables (ej. Wait)
    │   ├── questions/            # Preguntas Screenplay (ValidationPage, VerifyCategory)
    │   ├── tasks/                # Tareas Screenplay (UserLogged, SelectLaptops, SelectProduct)
    │   └── userinterfaces/       # Page objects / Targets (DemoBlazeHome, DemoBlazeProductPage)
    └── test
        ├── java/co/com/tuya/certifications/demoblazetuya
        │   ├── runners/          # Runner de Cucumber + Serenity (UserSeeLaptops)
        │   └── stepdefinitions/  # Step definitions en español
        └── resources/features/
            └── precios_laptops.feature   # Escenarios Gherkin
```

## Requisitos previos

- JDK instalado (Java 8+; el proyecto no fija un `sourceCompatibility` explícito en `build.gradle`).
- Google Chrome instalado, con una versión compatible con el `chromedriver.exe` incluido en la raíz del repositorio.
- No es necesario instalar Gradle: el proyecto incluye el Gradle Wrapper (`gradlew` / `gradlew.bat`).

## Cómo ejecutar las pruebas

Clonar el repositorio y, desde la raíz del proyecto, ejecutar:

```bash
# Linux / macOS
./gradlew clean test

# Windows
gradlew.bat clean test
```

Esto compila el proyecto, ejecuta el runner de Cucumber (`UserSeeLaptops`), que a su vez corre los escenarios definidos en `src/test/resources/features/precios_laptops.feature` contra `https://www.demoblaze.com`.

### Generar el reporte de Serenity

El proyecto aplica el plugin `net.serenity-bdd.aggregator`, que agrega los resultados de la ejecución en un reporte HTML. Para generarlo:

```bash
./gradlew aggregate
```

O bien encadenar ambos pasos en una sola ejecución:

```bash
./gradlew clean test aggregate
```

### Ver el reporte de resultados

Una vez generado, el reporte queda disponible en:

```
target/site/serenity/index.html
```

Ábrelo con cualquier navegador para ver el detalle de los escenarios ejecutados, pasos, capturas de pantalla y resultados.

## Configuración de WebDriver

La configuración del navegador se define en [`serenity.properties`](./serenity.properties):

- Navegador: `chrome`
- Driver: `chromedriver.exe` (ubicado en la raíz del proyecto)
- Modo: `--incognito`, con `safebrowsing` deshabilitado
- Timeouts: 15000 ms (espera implícita y espera de WebDriver)
- Navegador maximizado al iniciar

## Notas

- Los escenarios y los step definitions están escritos en español (`#language: es`), siguiendo la sintaxis de Cucumber en español (`Dado`, `Cuando`, `Entonces`).
- Las credenciales usadas en el escenario de login son datos de prueba propios del sitio de práctica DemoBlaze y no representan datos reales.
