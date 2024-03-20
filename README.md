# CryptoBot - телеграм - бот

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

## Стек используемых технологий
Java Core, Spring Boot, Hibernate, JDBC, Security, MySQL, Telegrambots.

## Настройки для запуска

### Зависимости
В данном проекте используется Spring, gradle используется в качестве системы сборки.

     implementation 'org.springframework.boot:spring-boot-starter'
	   implementation "org.telegram:telegrambots:$telegrambotsVersion"
	   implementation "org.telegram:telegrambotsextensions:$telegrambotsVersion"
	   implementation "ch.qos.logback:logback-classic:$logbackVersion"
	   implementation "ch.qos.logback:logback-core:$logbackVersion"
	   implementation group: 'javax.xml.bind', name: 'jaxb-api', version: jaxbApiVersion
	   implementation group: 'org.springframework', name: 'spring-orm', version: springOrmVersion
	   implementation 'org.hibernate:hibernate-core:5.6.2.Final'
	   implementation 'mysql:mysql-connector-java:8.0.33'

### Запуск

Что бы запустить проект  нужно в файле application.yml указать имя и токен бота, что бы подключиться к телеграм боту 

    username: 
    token:

Так же в файле hibernate.cfg.xml, нужно указать такблицу, которую будете добавлять пользователя, имя и пароль, для подключении таблицы MySQL

        <property name="connection.url">jdbc:mysql://localhost:3306/ имя таблицы</property>
        <property name="connection.username"> имя базы даных </property>
        <property name="connection.password">пароль</property>




