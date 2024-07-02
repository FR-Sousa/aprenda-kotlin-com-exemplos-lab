enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }

    fun desmatricular(usuario: Usuario) {
        inscritos.remove(usuario)
        println("Usuário ${usuario.nome} desmatriculado da formação $nome")
    }

    fun calcularDuracaoTotal(): Int {
        return conteudos.sumBy { it.duracao }
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Desenvolvimento Android com Kotlin", 120)

    // Criando uma formação e adicionando conteúdos
    val formacaoKotlin = Formacao("Formação Kotlin")
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)

    // Criando usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("Carlos")
    val usuario4 = Usuario("Daniela")
    val usuario5 = Usuario("Eduardo")

    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)
    formacaoKotlin.matricular(usuario4)
    formacaoKotlin.matricular(usuario5)

    // Mostrando a duração total da formação
    println("Duração total da formação ${formacaoKotlin.nome}: ${formacaoKotlin.calcularDuracaoTotal()} minutos")

    // Desmatriculando um usuário
    formacaoKotlin.desmatricular(usuario2)
}
