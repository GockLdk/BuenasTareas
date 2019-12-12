# Especificaciones de la Tarea
### JSON-PYTHON
Considere el siguiente conjunto de datos en formato json: **Catalogo_de_Bienes_Inmuebles_en_administracion_susceptibles_de_venta.json**

El archivo tiene un arreglo de objetos del siguiente tipo:

```json
[
  {
    "NumeroSIAB": "3821",
    "Estatus": "CPV",
    "DescripcionEstatus": "BIEN COMPROMETIDO PARA VENTA",
    "Vocacion": "DERECHOS DE COPROPIEDAD",
    "TipoInmueble": "DERECHOS DE COPROPIEDAD",
    "Ubicacion": "DERECHOS DE COPROPIEDAD ... CÓDIGO POSTAL 76807.",
    "EntidadFederativa": "QUERETARO",
    "Municipio": "SAN JUAN DEL RÍO",
    "SuperficieTerrenoEnM2": "50% DE 13 720.00 M2.",
    "SuperficieConstruccionEnM2": "SI",
    "Copropiedad": "PROCURADURÍA GENERAL DE LA REPÚBLICA (PGR)",
    "EntidadTransferente": "PJ (3)  CE (1 10)",
    "ProblematicaJuridica": "PJ (3)  CE (1 10)",
    "DescripcionProblematicaJuridica": "SEI 12/19",
    "EventoActual": ""
  },
  {
    "NumeroSIAB": "289069",
    "Estatus": "CPV",
    "DescripcionEstatus": "BIEN COMPROMETIDO PARA VENTA",
    "Vocacion": "COMERCIAL",
    "TipoInmueble": "COMERCIAL",
    "Ubicacion": "13 LOCALES COMERCIALES",
    "EntidadFederativa": "VERACRUZ",
    "Municipio": "COATZACOALCOS",
    "SuperficieTerrenoEnM2": "15.12 M2.",
    "SuperficieConstruccionEnM2": "NO",
    "Copropiedad": "REC MANDATO (BNCI)",
    "EntidadTransferente": "PJ (0)  CE (1)",
    "ProblematicaJuridica": "PJ (0) No tienen problemática jurídica alguna  es decir son regulares",
    "DescripcionProblematicaJuridica": "SEI 12/19",
    "EventoActual": ""
  }
]
```


### 1.1. A

Escribe un programa que lea el archivo json y escriba en un archivo del mismo tipo unicamente los datos: NumeroSIAB, TipoInmueble y EntidadFederativa (el archivo que escriban puede omitir los saltos de linea).

ejemplo:
```json
[
  {
    "NumeroSIAB": "3821",
    "TipoInmueble": "DERECHOS DE COPROPIEDAD",
    "EntidadFederativa": "QUERETARO",
  },
  {
    "NumeroSIAB": "289069",
    "TipoInmueble": "COMERCIAL",
    "EntidadFederativa": "VERACRUZ",
  },
  {
    "NumeroSIAB": "289070",
    "TipoInmueble": "COMERCIAL",
    "EntidadFederativa": "VERACRUZ",
  }
]
```
### 1.2. B

Escribe un programa que lea el archivo json y guarde en un archivo del mismo tipo los siguientes datos para cada EntidadFederativa :

- El número de elementos en el archivo original.
- La lista de estos elementos con los atributos que se muestran en el siguiente ejemplo:

```json
[
  {
    "EntidadFederativa": "QUERETARO",
    "NumeroInmuebles": 1,
    "Inmuebles": [
        {
          "NumeroSIAB": "3821",
          "Estatus": "CPV",
          "DescripcionEstatus": "BIEN COMPROMETIDO PARA VENTA",
          "TipoInmueble": "DERECHOS DE COPROPIEDAD"
        }
    ]
  },
  {
    "EntidadFederativa": "VERACRUZ",
    "NumeroInmuebles": 2,
    "Inmuebles": [
        {
          "NumeroSIAB": "289069",
          "Estatus": "CPV",
          "DescripcionEstatus": "BIEN COMPROMETIDO PARA VENTA",
          "TipoInmueble": "COMERCIAL"
        },
        {
          "NumeroSIAB": "289070",
          "Estatus": "CPV",
          "DescripcionEstatus": "BIEN COMPROMETIDO PARA VENTA",
          "TipoInmueble": "COMERCIAL"
        }
    ]
  }
]
```
### 1.3. Punto extra tarea

Escribe el archivo del punto 1.1 a un archivo excel (.xls) usando openpyxl

**Nota**:

- El reporte detallado de la tarea esta en el archivo [Reporte](Reporte.md).
