import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {

    const [activePage, setActivePage] = useState(0);

    const [page, setpage] = useState<SalePage>({
        first: true,
        number: 0,
        totalElements: 0,
        totalPages: 0,
        last: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=${activePage}&size=5`)
            .then(Response => {
                setpage(Response.data)
            });
    }, [activePage]);

    const changePage =(index : number) => {
        setActivePage(index);
    }
    return (
        <>
            <Pagination page={page} onPageChange={changePage} />
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Vendedor</th>
                            <th>Clientes visitados</th>
                            <th>Negócios fechados</th>
                            <th>Valor</th>
                            <th className="text-center">Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        {page.content?.map(item => (
                            <tr key={item.id}>
                                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                                <td>{item.seller.name}</td>
                                <td>{item.visited}</td>
                                <td>{item.deals}</td>
                                <td>{item.amount.toFixed(2)}</td>
                                <td className="text-center">
                                    <Link className="btn btn-warning space-button" to="/dashboard">
                                        Vizualizar
                                    </Link>
                                    <Link className="btn btn-danger" to="/dashboard">
                                        Deletar
                                    </Link>
                                    <Link className="btn btn-primary space-button" to="/dashboard">
                                        Novo
                                    </Link>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <Pagination page={page} onPageChange={changePage} />
        </>
    );
}

export default DataTable;