package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util

import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.R
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.response.MovieResponse
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.response.TvShowResponse
import java.util.*

object DummyData {

    fun generateDummyMovies(): ArrayList<Movie> {
        val movies = ArrayList<Movie>()
        movies.add(
            Movie(
                1,
                R.drawable.poster_aquaman,
                "Aquaman",
                "Action, Adventure, Fantasy",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a very large army, Orm plans to conquer the remaining ocean people and then to the surface. Stand in his way is Arthur Curry, the half-human half-brother of Orm and the true heir to the throne.",
                "2018",
                false
            )
        )
        movies.add(
            Movie(
                2,
                R.drawable.poster_avengerinfinity,
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018",
                false
            )
        )
        movies.add(
            Movie(
                3,
                R.drawable.poster_bumblebee,
                "Bumble Bee",
                "Action, Adventure, Science Fiction",
                "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.",
                "2018",
                false
            )
        )
        movies.add(
            Movie(
                4,
                R.drawable.poster_deadpool,
                "Deadpool",
                "Comedy, Action",
                "A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's.",
                "2018",
                false
            )
        )
        movies.add(
            Movie(
                5,
                R.drawable.poster_dragonball,
                "Dragon Ball",
                "Action, Adventure, Animation, Kids",
                "Trunks returns from the future to train with Goku and Vegeta. However, it disappears without warning. Then the mysterious Fu bursts in, telling them that Trunks has been imprisoned in the Prison Planet, a mysterious complex in an unknown place in the universes. The group seeks the dragon balls to free Trunks, but an endless battle awaits them! Will Goku and the others rescue Trunks and escape the Prison Planet",
                "2018",
                false
            )
        )
        movies.add(
            Movie(
                6,
                R.drawable.poster_mortalengine,
                "Mortal Engine",
                "Adventure, Fantasy",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2018",
                false
            )
        )
        movies.add(
            Movie(
                7,
                R.drawable.poster_preman,
                "Preman Pensiun",
                "Comedy, Drama",
                "After three years, the business of Muslihat Epi Kusnandar, who has retired as a thug, has a problem. Sales decline. Muslihat also faces new problems when Safira (Safira Maharani), her only daughter, grows up in adolescence and begins to be visited by boys. A bigger problem: frictions between his former subordinates.",
                "2019",
                false
            )
        )
        movies.add(
            Movie(
                8,
                R.drawable.poster_robinhood,
                "Robin Hood",
                "Adventure, Action",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "2018",
                false
            )
        )
        movies.add(
            Movie(
                9,
                R.drawable.poster_spiderman,
                "Spiderman",
                "Fantasy, Action",
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers.",
                "2002",
                false
            )
        )
        movies.add(
            Movie(
                10,
                R.drawable.poster_venom,
                "Venom",
                "Science Fiction, Action",
                "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                "2018",
                false
            )
        )
        return movies
    }

    fun generateRemoteDummyMovies(): ArrayList<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                1,
                R.drawable.poster_aquaman,
                "Aquaman",
                "Action, Adventure, Fantasy",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a very large army, Orm plans to conquer the remaining ocean people and then to the surface. Stand in his way is Arthur Curry, the half-human half-brother of Orm and the true heir to the throne.",
                "2018"
            )
        )
        movies.add(
            MovieResponse(
                2,
                R.drawable.poster_avengerinfinity,
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018"
            )
        )
        movies.add(
            MovieResponse(
                3,
                R.drawable.poster_bumblebee,
                "Bumble Bee",
                "Action, Adventure, Science Fiction",
                "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.",
                "2018"
            )
        )
        movies.add(
            MovieResponse(
                4,
                R.drawable.poster_deadpool,
                "Deadpool",
                "Comedy, Action",
                "A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's.",
                "2018"
            )
        )
        movies.add(
            MovieResponse(
                5,
                R.drawable.poster_dragonball,
                "Dragon Ball",
                "Action, Adventure, Animation, Kids",
                "Trunks returns from the future to train with Goku and Vegeta. However, it disappears without warning. Then the mysterious Fu bursts in, telling them that Trunks has been imprisoned in the Prison Planet, a mysterious complex in an unknown place in the universes. The group seeks the dragon balls to free Trunks, but an endless battle awaits them! Will Goku and the others rescue Trunks and escape the Prison Planet",
                "2018"
            )
        )
        movies.add(
            MovieResponse(
                6,
                R.drawable.poster_mortalengine,
                "Mortal Engine",
                "Adventure, Fantasy",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2018"
            )
        )
        movies.add(
            MovieResponse(
                7,
                R.drawable.poster_preman,
                "Preman Pensiun",
                "Comedy, Drama",
                "After three years, the business of Muslihat Epi Kusnandar, who has retired as a thug, has a problem. Sales decline. Muslihat also faces new problems when Safira (Safira Maharani), her only daughter, grows up in adolescence and begins to be visited by boys. A bigger problem: frictions between his former subordinates.",
                "2019"
            )
        )
        movies.add(
            MovieResponse(
                8,
                R.drawable.poster_robinhood,
                "Robin Hood",
                "Adventure, Action",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "2018"
            )
        )
        movies.add(
            MovieResponse(
                9,
                R.drawable.poster_spiderman,
                "Spiderman",
                "Fantasy, Action",
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers.",
                "2002"
            )
        )
        movies.add(
            MovieResponse(
                10,
                R.drawable.poster_venom,
                "Venom",
                "Science Fiction, Action",
                "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                "2018"
            )
        )
        return movies
    }

    @JvmStatic
    fun generateDummyTvShow(): ArrayList<TvShow> {
        val tvShows = ArrayList<TvShow>()
        tvShows.add(
            TvShow(
                1,
                R.drawable.poster_arrow,
                "Arrow",
                "Drama, Action & Adventure",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012",
                false
            )
        )
        tvShows.add(
            TvShow(
                2,
                R.drawable.poster_doom_patrol,
                "Doom Patrol",
                "Sci-Fi, Fantasy, Action & Adventure",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019",
                false
            )
        )
        tvShows.add(
            TvShow(
                3,
                R.drawable.poster_dragon_ball,
                "Dragon Ball",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986",
                false
            )
        )
        tvShows.add(
            TvShow(
                4,
                R.drawable.poster_fairytail,
                "Fairytail",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "2009",
                false
            )
        )
        tvShows.add(
            TvShow(
                5,
                R.drawable.poster_family_guy,
                "Family Guy",
                "Animation, Comedy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999",
                false
            )
        )
        tvShows.add(
            TvShow(
                6,
                R.drawable.poster_mortalengine,
                "Mortal Engine",
                "Adventure, Fantasy",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2018",
                false
            )
        )
        tvShows.add(
            TvShow(
                7,
                R.drawable.poster_naruto_shipudden,
                "Naruto Shipudden",
                "Animation, Comedy, Drama",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "2007",
                false
            )
        )
        tvShows.add(
            TvShow(
                8,
                R.drawable.poster_supergirl,
                "Supergirl",
                "Action, Adventure, Drama, Science Fiction",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "2015",
                false
            )
        )
        tvShows.add(
            TvShow(
                9,
                R.drawable.poster_the_simpson,
                "The Simpson",
                "Action, Adventure, Sci-Fi & Fantasy",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989",
                false
            )
        )
        tvShows.add(
            TvShow(
                10,
                R.drawable.poster_the_umbrella,
                "The Umbrella",
                "Science Fiction, Action",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "2019",
                false
            )
        )
        return tvShows
    }

    fun generateRemoteDummyTvShow(): ArrayList<TvShowResponse> {
        val tvShows = ArrayList<TvShowResponse>()
        tvShows.add(
            TvShowResponse(
                1,
                R.drawable.poster_arrow,
                "Arrow",
                "Drama, Action & Adventure",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012"
            )
        )
        tvShows.add(
            TvShowResponse(
                2,
                R.drawable.poster_doom_patrol,
                "Doom Patrol",
                "Sci-Fi, Fantasy, Action & Adventure",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019"
            )
        )
        tvShows.add(
            TvShowResponse(
                3,
                R.drawable.poster_dragon_ball,
                "Dragon Ball",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986"
            )
        )
        tvShows.add(
            TvShowResponse(
                4,
                R.drawable.poster_fairytail,
                "Fairytail",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "2009"
            )
        )
        tvShows.add(
            TvShowResponse(
                5,
                R.drawable.poster_family_guy,
                "Family Guy",
                "Animation, Comedy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999"
            )
        )
        tvShows.add(
            TvShowResponse(
                6,
                R.drawable.poster_mortalengine,
                "Mortal Engine",
                "Adventure, Fantasy",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2018"
            )
        )
        tvShows.add(
            TvShowResponse(
                7,
                R.drawable.poster_naruto_shipudden,
                "Naruto Shipudden",
                "Animation, Comedy, Drama",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "2007"
            )
        )
        tvShows.add(
            TvShowResponse(
                8,
                R.drawable.poster_supergirl,
                "Supergirl",
                "Action, Adventure, Drama, Science Fiction",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "2015"
            )
        )
        tvShows.add(
            TvShowResponse(
                9,
                R.drawable.poster_the_simpson,
                "The Simpson",
                "Action, Adventure, Sci-Fi & Fantasy",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989"
            )
        )
        tvShows.add(
            TvShowResponse(
                10,
                R.drawable.poster_the_umbrella,
                "The Umbrella",
                "Science Fiction, Action",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "2019"
            )
        )
        return tvShows
    }
}