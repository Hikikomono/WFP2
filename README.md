# Glance Iteration 1 (14. Mär 2021)
## Layouts
Here you can find a description of the functions of this app in the current development cycle.
### Glance (Overview Screen)

![](https://i.imgur.com/U46Qt1h.png)

This screen displays all available locations where todos can be placed. One location is the *Inbox*. Here you can find any todo that does not meet any criteria to be placed in an other location. In *Today* you can find all todos that are due to today. The *Schedule for Today* area dons not show any todos. Instead calendar entries are being displayed that reflect what's up for today. In the *Habit* section you can find repeating todos. *Overdue* collects all todos that were already due and are late (hurry up).

Every location has a counter that counts the total of current todos in the specific area.

### Todos
![](https://i.imgur.com/vaFjXWO.png)

This view looks similar in every category that displays a list of todos. Every todo has a checkbox. If you are done with a todo simply tap on it to check it. Tapping the action (+) button allows you to add a new todo.

### Edit a Todo

![](https://i.imgur.com/Mqvierf.png)
Here you can edit your todo. You can give it a title and a description. If your todo is repeating you can mark it as a habit. The icon below the habit checkbox shows the area where the todo should be placed. By tapping on the icons in the bottom right corner you can set more detailed information for your todo. Form left to right, the first one sets a due date. The next sets a tag. The icon with the flag allows you to set a deadline to your todo.


# Glance Kick-Off (Aug 5, 2020)
> Ideas for the overall goal after set amount of development cycles.
[TOC]
## Main Focus
+ To-Dos
+ Calendar (iCal integration)
+ Reminders (Notification)
+ Mood tracking
+ Cross-Platform
## Design Philosophy
In erster Linie soll die App sich den Entwicklen gerecht anpassen. Welche Features in die App aufgenommen werden hängt nicht von einer angenommenen User-base ab, sondern hängt komplett von den Developern (Roberto, Johannes) ab.
### Feeling eines Todos
Ein To-Do soll sich wie ein reales Objekt anfühlen, und nicht wie ein Element einer generischen Tablle. In einer Tabelle kann alles mit einem Klick geordnet werden. Ein reales Objekt muss mit Hand an seinen gewünbschten Platz verschoben werden. Deshalb Ordnen sich To-Dos nicht automatisch. Möchte der User ein ToDo an einer anderen Stelle haben (zu Beginn einer Liste) so muss das Element vom User die Reihenfolge verändert werden.
## Featues
### Moods
Der User stellt sich die Frage, wie ist der Tag gelaufen?
Der User kann auch Text eingeben um den Tag zu berschreiben.
Der User kann zw. 5 Smileys wählen. (OMEGA HAPPY, GOOD, MEH, SAD, WELTUNTERGANG).
Die Abfrage der Moods soll am Ende des Tages stattfinden (User legt den Zeitpunkt selber fest).

> Easter-Egg -> Echte Fotos der Developer für die Smileys.

Es ist möglich jede To-Do einzeln zu bewerten.
## Habit
Aufgaben die sich wiederholen werden als "Habit" gekennzeichnet.
### Streaks
Bei sich wiederholenden Eregnissen, werden Streaks angezeigt. Ab 7 Tagen ist man "on Fire" (-> wird visuell dargestellt).

## Archivements
Meilensteine die erreicht wurden werden in der App angezeigt.

> Beispiel: Du hast 100 aufgaben erledigt!

## Dashboard
Gibt einen guten Überblick über die bevorstehenden Ereignisse des Tages.
Zeigt Informationen aus dem Kalender, Todos und Habits.
Inhalte des Dashboards:
+ Kalender (Agenda)
+ To-Dos
+ Habits
+ Uhr
+ Wetter

Button der einen Blick auf der nächsten Tag erlaubt (Vorschau).

## Tags
Tags können
+ To-Dos
+ Kalendereinträgen
+ Habits

zugewiesen werden.

## Cross-Platform
Programm ist als Android-App und als Web-App verfügbar.
