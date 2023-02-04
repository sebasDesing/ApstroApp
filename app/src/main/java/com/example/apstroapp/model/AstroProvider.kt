package com.example.apstroapp.model



class AstroProvider {
    companion object {

        fun random(): AstroTypeModel {
            val position = (0..10).random()
            return astros[position]
        }

        private val astros = listOf(
            AstroTypeModel(
                quote = "It’s not a bug. It’s an undocumented feature!",
                author = "Anonymous"
            ),
            AstroTypeModel(
                quote = "“Software Developer” – An organism that turns caffeine into software",
                author = "Anonymous"
            ),
            AstroTypeModel(
                quote = "If debugging is the process of removing software bugs, then programming must be the process of putting them in",
                author = "Edsger Dijkstra"
            ),
            AstroTypeModel(
                quote = "A user interface is like a joke. If you have to explain it, it’s not that good.",
                author = "Anonymous"
            ),
            AstroTypeModel(
                quote = "I don’t care if it works on your machine! We are not shipping your machine!",
                author = "Vidiu Platon"
            ),
            AstroTypeModel(
                quote = "Measuring programming progress by lines of code is like measuring aircraft building progress by weight.",
                author = "Bill Gates"
            ),
            AstroTypeModel(
                quote = "My code DOESN’T work, I have no idea why. My code WORKS, I have no idea why.",
                author = "Anonymous"
            ),
            AstroTypeModel(quote = "Things aren’t always #000000 and #FFFFFF", author = "Anonymous"),
            AstroTypeModel(quote = "Talk is cheap. Show me the code.", author = "Linus Torvalds"),
            AstroTypeModel(
                quote = "Software and cathedrals are much the same — first we build them, then we pray.",
                author = "Anonymous"
            ),
            AstroTypeModel(quote = "¿A que esperas?, suscríbete.", author = "AristiDevs")
        )
    }
}