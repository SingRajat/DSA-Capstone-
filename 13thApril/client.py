import socket

HOST = '127.0.0.1'  # same as server
PORT = 65432        # same port as server

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
    client_socket.connect((HOST, PORT))
    print(f"Connected to server at {HOST}:{PORT}")

    while True:
        message = input("Enter message (type 'exit' to quit): ")
        if message.lower() == 'exit':
            break

        client_socket.sendall(message.encode('utf-8'))
        data = client_socket.recv(1024)

        print(f"Received from server: {data.decode('utf-8')}")