#CryptoBot - телеграм - бот

## Описание

Проект по созданию телеграм - бота, который отслеживает цену биткоина в реальном времени. Создает подписку для клиент, по какой цене пользователь хочет купить биткоин и оповещает его.

/start - при нажатии команды, появляется сообщение о командах и краткое сообщение о боте. Так же проверяется пользователь, если он в базе данных. Если его нет то он добавляется в базу данных.

/get_price - при нажатии команды, парсится цена с сайта binance биткоина в реальном времени и передается сообщение пользователю в телеграм. 

/subscribe XXX - при нажатии команды, пользователь добавляет указанную цену по которой хочет купить биткоин. Она добавляется в базу данных. При повторной команде, цена в базе данных обновляется 

/get_subscription  - при нажатии команды, отправляет сообщение пользователю, какую цену ранее клиент указал. Если пользователь не указывал цену, ему приходит сообщение, нет активной подписки. 

/unsubscribe - при нажатии команды, удаляется из базы данных цена, которую пользователь указал. Если цены на биткоина не было, то появляется сообщение нет активной подписки.


![Бот](https://github.com/Misha7547/cryptoBot/assets/117103365/0133e668-c6ec-4692-beec-517d58d9bf87)

Как только пользователь добавил цену, по которой хочет купить биткоин, происходит проверка каждые 2 минуты. 
Если цена биткоина доходит до нужной цены пользователя, ему приходит сообщение в чат, что нужно покупать биткоинт. Оповещение приходит с интервалом 10 минут. 

![Бот 2 ](https://github.com/Misha7547/cryptoBot/assets/117103365/c0bd0dac-7754-4591-a60b-55669405b7ed)

### База данных
Для удобной работы с postgreSql используется докер-образ,
вам не нужно самостоятельно устанавливать postgreSql.
Выполнив `docker-compose up`, вы запустите postgreSql с предустановленными
настройками (их посмотреть можно в файле `docker-compose.yaml`).
Для запуска докер образа вам понадобится установить `docker` и `docker-compose` 

### Spring проект

В данном проекте используется Spring, gradle используется в качестве системы сборки.
Основные зависимости уже указаны, но никто вам не запрещает добавлять новые.

В `application.yml` находятся конфигурируемые параметры нашего приложения
(в частности, там указывается токен вашего бота)


## Как запустить

При открытии директории через IntelliJ IDEA проект должен автоматически распознаться.
У вас должна появится `run configuration CryptoBotApplication` (зеленый треугольник),
если не появился, можно пройти в класс `CryptoBotApplication` и оттуда напрямую вызвать `main` метод.

