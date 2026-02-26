# ✏️ EJERCICIO 2: SISTEMA DE GESTIÓN DE CONTACTOS

## 🎯 **Objetivo:**
Crear un sistema de gestión de contactos usando ArrayList

## 📝 **Requerimientos:**

### **1. Usar ArrayList para:**
- Lista de nombres (String)
- Lista de teléfonos (String)
- Lista de emails (String)
- Lista de favoritos (Boolean)
- Lista de categorías (String): "Familia", "Trabajo", "Amigos"

### **2. Menú con opciones:**
1. Agregar contacto
2. Mostrar todos los contactos
3. Editar contacto
4. Eliminar contacto
5. Buscar contacto por nombre
6. Marcar/desmarcar como favorito
7. Mostrar solo favoritos
8. Filtrar por categoría
9. Ver estadísticas
0. Salir

### **3. Métodos requeridos:**

- agregarContacto(nombres, telefonos, emails, favoritos, categorias, nombre, telefono, email, categoria)
- mostrarContactos(nombres, telefonos, emails, favoritos, categorias)
- editarContacto(nombres, telefonos, emails, categorias, indice, nuevoNombre, nuevoTelefono, nuevoEmail, nuevaCategoria)
- eliminarContacto(nombres, telefonos, emails, favoritos, categorias, indice)
- buscarContacto(nombres, buscar)
- marcarFavorito(favoritos, indice)
- mostrarFavoritos(nombres, telefonos, emails, favoritos, categorias)
- filtrarPorCategoria(nombres, telefonos, emails, categorias, categoriaBuscada)
- contarPorCategoria(categorias, categoriaBuscada)
- mostrarEstadisticas(nombres, favoritos, categorias)
- obtenerTextoCategoria(categoria) // "Familia", "Trabajo", "Amigos"
- validarEmail(email) // retorna true si contiene '@'


### **4. Validaciones:**
- Email debe contener '@'
- Teléfono debe tener al menos 7 dígitos
- Categoría debe ser válida (1=Familia, 2=Trabajo, 3=Amigos)
