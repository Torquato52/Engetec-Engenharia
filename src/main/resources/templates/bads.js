document.getElementById('meuBotao').addEventListener('click', function() {
    
    chamarEndpointJava();
});


function chamarEndpointJava() {
    alert("chamou pelmonseos")
    var url = 'http://localhost:8080/revisor';

    var options = {
        method: 'GET', // ou 'POST', dependendo da sua API
        headers: {
            'Content-Type': 'application/json', // ou outro tipo de conteúdo suportado pela sua API
            // Adicione headers adicionais, se necessário
        },
        // Adicione corpo da requisição se estiver usando método POST
        // body: JSON.stringify({ chave: 'valor' }),
    };

    // Fazendo a requisição usando a API Fetch
    fetch(url, options)
        .then(function(response) {
            // Verifica se a resposta é bem-sucedida
            if (!response.ok) {
                throw new Error('Erro ao chamar o endpoint: ' + response.status);
            }
            // Processa a resposta
            return response.json(); // ou response.text() se a resposta não for JSON
        })
        .then(function(data) {
            // Lida com os dados retornados pelo endpoint
            console.log('Resposta do endpoint:', data);
        })
        .catch(function(error) {
            // Lida com erros durante a requisição
            console.error('Erro na requisição:', error);
        });
} 
