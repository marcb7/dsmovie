import axios from "axios";
import { useEffect, useState } from "react";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { BASE_URL } from "utils/requests";
import { MoviePage } from "types/movie";

function Listing() {

    const [pageNumber, setPageNumber] = useState(0);

    const [page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)
            .then(response => {
                const data = response.data as MoviePage;
                setPage(data)
            });
    }, [pageNumber]);

    // Função com notação de expressão lambda, que vai mudar a página. Ela recebe como argumento um novo número de página (newPageNumber),
    // do tipo number. Sempre que eu chamar essa função com um novo número de página, vai lá no meu useState e atualiza o valor dele pelo setPageNumber().
    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <Pagination page={page} onChange={handlePageChange} />
            <div className="container">
                <div className="row">
                    {page.content.map(item => (
                        <div key={item.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                            <MovieCard movie={item} />
                        </div>
                    )
                    )}

                </div>
            </div>
        </>
    )
}

export default Listing;