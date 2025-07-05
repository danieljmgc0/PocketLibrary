// src/main.server.ts

/******************************************************************
 * IMPORTS NECESARIOS PARA SSR
 ******************************************************************/
import { bootstrapApplication } from '@angular/platform-browser';
import { provideServerRendering } from '@angular/platform-server';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withFetch } from '@angular/common/http';

/******************************************************************
 * TU COMPONENTE RAÍZ Y RUTAS
 ******************************************************************/
import { App } from './app/app';
import { routes } from './app/app.routes';  // tu array de Routes

/******************************************************************
 * CONFIGURACIÓN DE PROVEEDORES PARA EL SERVER
 ******************************************************************/
const serverConfig = {
  providers: [
    // Habilita el entorno de Server-Side Rendering
    provideServerRendering(),

    // Router en modo SSR
    provideRouter(routes),

    // HttpClient con fetch() en lugar de XHR
    provideHttpClient(withFetch())
  ]
};

/******************************************************************
 * BOOTSTRAP DE LA APP EN EL SERVIDOR
 ******************************************************************/
const bootstrap = () => bootstrapApplication(App, serverConfig);

export default bootstrap;
