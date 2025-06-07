package com.mast;

import java.util.Optional;

/**
 * App
 */
public class App {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		Task[] tasks = getTasks();
		Note[] notes = getNotes();

		for (Note note : notes)
			hashTable.insert(note.getId(), note);

		for (Task task : tasks)
			hashTable.insert(task.getId(), task);

		Task t1 = tasks[0];
		Task t2 = tasks[2];
		Note n1 = notes[4];
		Note n2 = new Note("no estoy en la tabla", "blanco");

		System.out.println("SE BUSCA: Lavar los platos");
		Optional<Register> t1searched = hashTable.search(t1.getId());
		System.out.println((t1searched.isPresent()) ? t1searched.get().getName() : "No se encontró");

		System.out.println("SE BUSCA: Estudiar inglés");
		Optional<Register> t2searched = hashTable.search(t2.getId());
		System.out.println((t2searched.isPresent()) ? t2searched.get().getName() : "No se encontró");

		System.out.println("SE BUSCA: Lavar la ropa");
		Optional<Register> n1searched = hashTable.search(n1.getId());
		System.out.println((n1searched.isPresent()) ? n1searched.get().getName() : "No se encontró");

		System.out.println("SE BUSCA: No estoy en la tabla");
		Optional<Register> n2searched = hashTable.search(n2.getId());
		System.out.println((n2searched.isPresent()) ? n2searched.get().getName() : "No se encontró");

		// hashTable.printAll();
	}

	private static Task[] getTasks() {
		return new Task[] {
				new Task("Lavar los platos", "Limpiar vajilla sucia del almuerzo"),
				new Task("Hacer ejercicio", "Rutina de cardio de 45 minutos"),
				new Task("Estudiar inglés", "Repasar vocabulario y gramática"),
				new Task("Comprar víveres", "Lista: arroz, pollo, verduras y frutas"),
				new Task("Llamar al dentista", "Agendar cita para limpieza dental"),
				new Task("Revisar emails", "Responder correos pendientes del trabajo"),
				new Task("Pasear al perro", "Caminata de 20 minutos por el parque"),
				new Task("Leer 30 páginas", "Continuar con novela de misterio"),
				new Task("Preparar presentación", "Slides para reunión del jueves"),
				new Task("Organizar escritorio", "Ordenar documentos y limpiar superficie"),
				new Task("Pagar facturas", "Servicios de luz, agua y teléfono"),
				new Task("Planchar ropa", "Camisas y pantalones para la semana"),
				new Task("Backup de fotos", "Respaldar imágenes en disco externo"),
				new Task("Reparar grifo", "Cambiar empaque que gotea en cocina"),
				new Task("Escribir en diario", "Reflexionar sobre eventos del día"),
				new Task("Actualizar CV", "Agregar experiencia laboral reciente"),
				new Task("Limpiar auto", "Lavado exterior e interior completo"),
				new Task("Revisar presupuesto", "Analizar gastos del mes anterior"),
				new Task("Contactar plomero", "Solicitar cotización para baño"),
				new Task("Meditar 15 minutos", "Práctica de mindfulness matutina"),
				new Task("Preparar almuerzo", "Ensalada de pollo con quinoa"),
				new Task("Revisar contratos", "Leer términos del seguro médico"),
				new Task("Arreglar jardín", "Podar arbustos y plantar flores"),
				new Task("Configurar respaldo", "Automatizar backup semanal de datos"),
				new Task("Practicar guitarra", "Ensayar acordes de canción nueva"),
		};
	}

	private static Note[] getNotes() {
		return new Note[] {
				new Note("desayuno a las 8", "amarillo"),
				new Note("correr 30 minutos", "verde"),
				new Note("tomar vitaminas", "rosa"),
				new Note("descongelar el pollo", "azul"),
				new Note("lavar la ropa", "blanco"),
				new Note("comprar leche y pan", "naranja"),
				new Note("reunión con equipo a las 10", "rojo"),
				new Note("terminar informe mensual", "morado"),
				new Note("llamar al cliente sobre presupuesto", "azul marino"),
				new Note("cumpleaños de mamá el viernes", "fucsia"),
				new Note("cita médica a las 3 pm", "verde claro"),
				new Note("pagar factura de electricidad", "gris"),
				new Note("cine con amigos el sábado", "dorado"),
				new Note("almuerzo familiar el domingo", "celeste"),
				new Note("terminar libro de fotografía", "violeta"),
				new Note("renovar licencia de conducir", "rojo intenso"),
				new Note("backup de archivos importantes", "negro"),
				new Note("nueva temporada de la serie", "turquesa"),
				new Note("descargar playlist para viaje", "lime"),
				new Note("reservar hotel para diciembre", "azul cielo"),
				new Note("revisión técnica del auto", "plateado"),
				new Note("regar las plantas", "verde musgo"),
				new Note("estudiar para el examen", "azul oscuro"),
				new Note("comprar regalo para Ana", "rosado"),
				new Note("cambiar aceite del auto", "marrón"),
		};
	}
}
