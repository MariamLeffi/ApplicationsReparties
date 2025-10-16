Activité 1.1
=>Le serveur, développé dans le package serverPackage, attend une connexion sur un port spécifique. Lorsqu’un client se connecte, un message s’affiche confirmant la connexion.
=>Le client, développé dans le package clientPackage, tente de se connecter au serveur via l’adresse IP (ou localhost). Une fois connecté, il affiche un message confirmant la réussite de la connexion.
Activité 1.2
=> Cette version de l’application client-serveur permet au client d’envoyer plusieurs entiers successivement. 
Pour chaque nombre, le serveur calcule x * 5 et renvoie le résultat. La communication se poursuit tant que l’utilisateur ne saisit pas 0, ce qui provoque la fermeture propre des sockets et l’arrêt du programme des deux côtés.
Activité 1.3
=>Le serveur utilise InetAddress et InetSocketAddress pour écouter sur son IP réelle et un port précis, permettant la connexion depuis d’autres machines du réseau. 
Il reçoit l’opération et les nombres, effectue le calcul et renvoie le résultat.
Le client se connecte à cette IP, envoie l’opération et les nombres, puis reçoit et affiche le résultat. 
Ainsi, la communication fonctionne entre deux machines distinctes.
