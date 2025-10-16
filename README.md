Activité2.1
=>Le programme Client.java permet à l’utilisateur de saisir une opération mathématique, de la vérifier localement, puis de l’envoyer au serveur. 
Avant l’envoi, il contrôle le format de l’expression et interdit la division par zéro. Cette validation côté client rend le programme plus rapide, 
plus sûr et évite d’envoyer des données erronées au serveur.
=>Le programme Server.java est la partie serveur de l’application. Il attend la connexion d’un client, puis reçoit une opération mathématique. 
Après avoir supprimé les espaces, il extrait les deux nombres et l’opérateur, effectue le calcul correspondant et renvoie le résultat au client. 
Le serveur se concentre uniquement sur le traitement, car la validation a déjà été faite côté client, ce qui rend le système plus simple et fiable.
Activité 2.2 
Cette application met en œuvre une communication client/serveur en Java basée sur l’échange d’objets. Le client saisit deux nombres et un opérateur arithmétique (+, -, *, /), puis envoie ces données sous forme d’un objet sérialisé de la classe Operation au serveur. Le serveur, après réception de l’objet, identifie l’opération demandée, effectue le calcul correspondant et renvoie le résultat au client. Ce dernier, affiche alors le résultat à l’écran. L’application illustre ainsi le principe de la sérialisation et de la transmission d’objets entre deux programmes Java à travers un réseau via les flux ObjectInputStream et ObjectOutputStream.
