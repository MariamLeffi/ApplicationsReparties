"TP4" 
=>Chat Unidirectionnel et Test avec un Seul Client:
Le client UDP saisit un nom et envoie des messages préfixés à un serveur qui écoute sur le port 1234 et affiche chaque message reçu avec l’IP et le port du client, permettant un chat unidirectionnel simple.
=>Chat Bidirectionnel et Diffusion à Plusieurs Clients:
Le serveur UDP maintient une liste des clients ayant envoyé un message et diffuse chaque nouveau message à tous les autres clients, tandis que chaque client utilise des threads pour envoyer et recevoir simultanément, permettant un chat bidirectionnel en temps réel entre plusieurs participants.
