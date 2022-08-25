# Rxtro React Sample

## **Modulo Basico de Liferay React**


Basado en la documentacion de Liferay 7.2:

> [Developing a React-Application](https://help.liferay.com/hc/en-us/articles/360029028051-Developing-a-React-Application)


## Crear

**Prequisitos:**
- Tener instado node/npm
- Tener instalado generator-liferay-js
- - > npm install -g yo generator-liferay-js

_(Correrlo como administrador si tira algun error de permisos)_

**Construir un nuevo modulo de React:**
- Dentro del workspace de React ejecutar: yo liferay-js
- Seleccionar: React Widget
- Tipear el nombre del modulo: Tener en cuenta la siguiente notación 
    - Los módulos para los Representeatives se nombraran  como “rep-xxxx-xxxx”
    - Los módulos para las Clinics se nombraran como “clinic-xxxx-xxxx”
    - Los módulos de servicios se nombraran como “retro-xxxx-xxxx”
    - …nuevas sugerencias.. bienvenidas!
- Dejar la descripción sugerida
- Elegir “Y” en localization support
- Elegir “n” en configuration support
- Tipear como nombre de categoría (respetar mayusculas y minúsculas): RxTro
- Configurar la direccion al bundle de Liferay
- Elegir que cree un contenido de ejemplo (sugerencia): Y


## Configurar

- Abrir el nuevo modulo con Visual Studio o el IDE que se utilice.
- Agregar referencias al modulo de React-provider
- - Editar el archivo .npmbundlerrc
- - - Agregar luego de dump-reporte el siguiente json de config:
```

"dump-report": true,
"config": {
        "imports": {
            "React-provider": {
			// DEPENDENCIAS
            }
        },
        "": {
            "React-provider": "^1.0.0"
        }
    }
```

- - Mover las dependencias que están en el package.json al archivo .npmbundlerrc
- - - En este caso solo están react y react-dom, entonces quedaría:
```

"dump-report": true,
"config": {
        "imports": {
            "React-provider": {
			    "react": "16.8.6",
       			"react-dom": "16.8.6"
            }
        },
        "": {
            "React-provider": "^1.0.0"
        }
    }
```
- - - Chequear que las dependencias y versiones están en el modulo de React-provider (en su package.json)

## Desplegar

- Eliminar la carpeta node_modules y build
- Correr el comando para instalar:
> npm install
- Correr el comando para desplagar:
> npm run deploy

## Testear

- Desplegar el nuevo modulo React en un pagina de Liferay
- Verificar que no haya errores en la consola del navegador

## Agregar dependencias de MaterialUI

- Agregar las siguentes dependencias de MaterialUI al archivo .npmbundlerrc,  estas deben estar en el modulo de React-provider.
- - "@material-ui/core": "^4.12.4"
- - "@material-ui/icons": "^4.11.3"
- - "@material-ui/styles": "^4.11.5"
```

"dump-report": true,
"config": {
        "imports": {
            "React-provider": {
			    "react": "16.8.6",
       			"react-dom": "16.8.6",
                "@material-ui/core": "^4.12.4",
				"@material-ui/icons": "^4.11.3",
				"@material-ui/styles": "^4.11.5"
            }
        },
        "": {
            "React-provider": "^1.0.0"
        }
    }
```

