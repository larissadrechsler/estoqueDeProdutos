
function atualizarTarefa(element) { 
    if (element.innerHTML === 'Concluída') { 
        element.innerHTML = 'Pendente'; 
        element.className = 'tarefa-pendente'; 
    } else { 
        element.innerHTML = 'Concluída'; 
        element.className = 'tarefa-concluida'; 
    } 
} 