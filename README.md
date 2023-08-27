# Neobis_Android_News_App


## Описание проекта

Данный проект представляет собой приложение: " News App", которое охватывает компоненты Android, такие как отображение текстов и изображений, фрагменты
и переходы на другие фрагменты, загрузка изображений, редактирование/ввод текста, архивирование товаров и их удаление, .

Цель проекта состоит в том, чтобы спроектировать и создать структуру новостного приложения, которое будет отображать список самых последних новостей. 
В данном приложении использовался навигация между фрагментами осуществляется с помощью Navigation Component.
А списки реализованы RecyclerView 
Так же использовались:
- RecyclerView
    - Adapter. Паттерн Adapter
    - Card layout
    - Bottom navigation с Bottom Navigation View
    - On Item Click
- Fragment, lifecycle
- Glide
-  Архитектура MVVM
- Coroutines
- Room для работы с базами данных
    - DAO(data access object), SQL queries(запросы), select, delete, update, ordering
    - Entity(таблицы), primary keys, column info
    - Database(getting access to your database, migration, etc)
 - Архитектура ViewModel
    - Что это за архитектура и чем она отличается от MVP
    - LiveData и MutableLiveData
- REST API
    - Queries(POST, GET, PUT, DELETE)
    - Server Response
    - JSON and GSON
- Для реализации запросов в приложении вы будете использовать библиотеку Retrofit.
- DiffUtils для быстрого обновления RecyclerView
Установлен слушатель для кнопкок с помощью setOnClickListener и On Item Click.

## Установка проекта

**MacOS:**
1. Установить Android Studio https://developer.android.com/studio/
2. Открыть проект или клонировать (клонировать этот проект по инструкции https://www.jetbrains.com/idea/guide/tutorials/creating-a-project-from-github/clone-from-github/)
3. Для запуска проекта в Android Studio нажмите на зеленый треугольник на панели сверху справа


**Windows:**
1. Установить Android Studio https://developer.android.com/studio/
2. Открыть проект или клонировать (клонировать этот проект по инструкции https://www.jetbrains.com/idea/guide/tutorials/creating-a-project-from-github/clone-from-github/)
3. Для запуска проекта в Android Studio нажмите на зеленый треугольник на панели сверху справа

## Функционал проекта 

Цель проекта состоит в том, чтобы спроектировать и создать структуру новостного приложения, которое будет отображать список самых последних новостей. 
- ProgressBar во время загрузки данных
- Поиск в списке новостей
- По нажатию на кнопку обновления в заголовке должен обновляться список новостей
- Отображение новостей должно быть реализовано с помощью RecyclerView
- Для каждой новостной карточки необходимо указать ее изображение, заголовок(название), описание, источник и дату публикации.
- При нажатии на каждый элемент должен открываться «веб-просмотр» с подробной информацией об этой новости.
- "web-view", который позволяет  просмотреть больше информации по  этой новости. (это системное окно представляет собой мини-браузер внутри приложения)
Мы можем нажать на карточку любой новости и провалиться в подробную информацию. Есть возможность залайкать новость, нажав на лайк. Из лайков мы можем убрать его из списка.
Так же можно нажать на стрелку в верхнем левом углу и вернуться назад к начальному списку

<img width="360" alt="Снимок экрана 2023-08-27 в 14 27 26" src="https://github.com/lizazueva/Neobis_Android_News_App/assets/56483500/22120f43-3609-46ae-994f-e6d01f25666f">
<img width="346" alt="Снимок экрана 2023-08-27 в 14 27 39" src="https://github.com/lizazueva/Neobis_Android_News_App/assets/56483500/34aa1663-c04c-4a06-b452-92ed4063d428">
<img width="382" alt="Снимок экрана 2023-08-27 в 14 27 52" src="https://github.com/lizazueva/Neobis_Android_News_App/assets/56483500/320c623f-4122-43e8-b139-81aa0cc2e73f">





## Автор проекта

Автор проекта: lizazazu@gmail.com


