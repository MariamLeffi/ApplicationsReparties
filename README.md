Activité 1.1
=>Le serveur, développé dans le package serverPackage, attend une connexion sur un port spécifique. Lorsqu’un client se connecte, un message s’affiche confirmant la connexion.
=>Le client, développé dans le package clientPackage, tente de se connecter au serveur via l’adresse IP (ou localhost). Une fois connecté, il affiche un message confirmant la réussite de la connexion.
Activité 1.2
=> Cette version de l’application client-serveur permet au client d’envoyer plusieurs entiers successivement. 
Pour chaque nombre, le serveur calcule x * 5 et renvoie le résultat. La communication se poursuit tant que l’utilisateur ne saisit pas 0, ce qui provoque la fermeture propre des sockets et l’arrêt du programme des deux côtés.
