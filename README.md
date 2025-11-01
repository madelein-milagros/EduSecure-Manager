# 🎓 Sistema de Gestión de Cursos con Spring Security

Una aplicación web completa desarrollada con Spring Boot 3.5.7 que implementa un sistema de gestión de cursos con autenticación y autorización usando Spring Security.

## ✨ Características Principales

- **🔐 Autenticación Segura**: Implementación de Spring Security con roles de usuario
- **👥 Control de Accesos**: Roles ADMIN y USER con permisos diferenciados
- **📚 Gestión de Cursos**: CRUD completo para administración de cursos
- **🎨 Interfaz Moderna**: Diseño responsivo con colores pasteles y Bootstrap 5
- **🗄️ Persistencia de Datos**: MySQL con Spring Data JPA
- **🌐 Internacionalización**: Soporte para múltiples idiomas
- **📱 Diseño Responsive**: Compatible con dispositivos móviles

## 🛠️ Tecnologías Utilizadas

### Backend
- **Spring Boot 3.5.7** - Framework principal
- **Spring Security 6** - Autenticación y autorización
- **Spring Data JPA** - Persistencia de datos
- **Spring Validation** - Validación de formularios
- **MySQL Connector** - Base de datos

### Frontend
- **Thymeleaf** - Motor de plantillas
- **Bootstrap 5.1.3** - Framework CSS
- **CSS Personalizado** - Diseño con colores pasteles
- **Thymeleaf Extras Spring Security** - Integración de seguridad en vistas

### Herramientas
- **Maven** - Gestión de dependencias
- **Java 21** - Lenguaje de programación
- **Spring Boot DevTools** - Desarrollo en caliente

## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 21 o superior
- Maven 3.6+
- MySQL 8.0+
- Git

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/madelein-milagros/EduSecure-Manager.git
   cd tu-repositorio

Configurar la base de datos

sql

Download
CREATE DATABASE security_db;
Configurar las credenciales en src/main/resources/application.properties

properties

Download
spring.datasource.url=jdbc:mysql://localhost:3306/security_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
Compilar y ejecutar la aplicación

bash

Download
mvn clean install
mvn spring-boot:run
Acceder a la aplicación

text

Download
http://localhost:8080
👤 Usuarios de Prueba
La aplicación crea automáticamente dos usuarios al iniciar:

Administrador
Usuario: admin

Contraseña: 12345

Permisos: Crear, editar, eliminar y ver cursos

Usuario Normal
Usuario: user

Contraseña: 12345

Permisos: Solo ver cursos

📋 Funcionalidades
🔐 Módulo de Seguridad
Login personalizado con Spring Security

Control de acceso basado en roles

Logout seguro

Página de error 403 personalizada

📚 Módulo de Cursos
Listar cursos: Visualización en tabla con diseño moderno

Crear cursos: Formulario con validaciones

Editar cursos: Modificación de información existente

Eliminar cursos: Eliminación con confirmación

Ver detalles: Información completa del curso

🎨 Características de UI/UX
Diseño con colores pasteles suaves

Interfaz responsiva y mobile-friendly

Iconos emoji para mejor experiencia de usuario

Animaciones suaves en hover

Alertas y mensajes de feedback

🗂️ Estructura del Proyecto
text

Download
src/main/java/tarea11/demo/
├── config/                 # Configuraciones
│   ├── SpringSecurityConfig.java
│   ├── MvcConfig.java
│   ├── PasswordConfig.java
│   └── DataInitializer.java
├── controller/             # Controladores
│   ├── CursoController.java
│   ├── LocaleController.java
│   └── MainController.java
├── entities/               # Entidades JPA
│   ├── Curso.java
│   ├── Usuario.java
│   └── Rol.java
├── persistence/            # Repositorios
│   ├── CursoDao.java
│   └── UsuarioDao.java
└── services/               # Lógica de negocio
├── CursoService.java
├── CursoServiceImpl.java
└── UsuarioService.java

src/main/resources/
├── static/css/            # Estilos personalizados
│   └── styles.css
├── templates/             # Vistas Thymeleaf
│   ├── cursos/
│   │   ├── listar.html
│   │   ├── form.html
│   │   └── ver.html
│   ├── home.html
│   ├── login.html
│   └── error_403.html
└── application.properties # Configuración
🔧 Configuración de Desarrollo
Variables de Entorno
properties

Download
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/security_db
spring.datasource.username=root
spring.datasource.password=password

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Thymeleaf
spring.thymeleaf.cache=false

# Server
server.port=8080
Comandos Útiles
bash

Download
# Ejecutar en desarrollo
mvn spring-boot:run

# Compilar para producción
mvn clean package

# Ejecutar tests
mvn test

# Actualizar dependencias
mvn dependency:resolve
🌐 Endpoints Principales
Método	URL	Descripción	Rol Requerido
GET	/	Página de inicio	Público
GET	/login	Formulario de login	Público
GET	/cursos/listar	Lista de cursos	USER, ADMIN
GET	/cursos/form	Formulario nuevo curso	ADMIN
POST	/cursos/form	Guardar curso	ADMIN
GET	/cursos/editar/{id}	Editar curso	ADMIN
GET	/cursos/eliminar/{id}	Eliminar curso	ADMIN
GET	/cursos/ver/{id}	Ver detalles	USER, ADMIN
🐛 Solución de Problemas
Error común: "Property 'nome' cannot be found"
Solución: Asegurarse que en las plantillas Thymeleaf se use curso.nombre en lugar de curso.nome

Error: Dependencia circular
Solución: Verificar la configuración de SpringSecurityConfig y DataInitializer

Base de datos no conecta
Solución: Verificar credenciales en application.properties y que MySQL esté ejecutándose

🤝 Contribución
Fork el proyecto

Crea una rama para tu feature (git checkout -b feature/AmazingFeature)

Commit tus cambios (git commit -m 'Add some AmazingFeature')

Push a la rama (git push origin feature/AmazingFeature)

Abre un Pull Request

📝 Licencia
Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE para más detalles.

👨‍💻 Autor
Milagros Madelein

GitHub: https://github.com/madelein-milagros

Email: milagrosramoschamorro@gmail.com

🙏 Agradecimientos
Spring Boot team por el excelente framework

Bootstrap por el sistema de diseño

Comunidad de Stack Overflow por el soporte