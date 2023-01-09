import {Col, Container, Nav, Navbar, Row, Table} from "react-bootstrap";
import {useEffect, useState} from "react";

export default function Invoices() {
    const [amount, setAmount] = useState(0);
    const [quantity, setQuantity] = useState(0);
    const [total, setTotal] = useState(0);
    const [newAmount, setNewAmount] = useState(0);
    const [newQuantity, setNewQuantity] = useState(0);
    const [newTotal, setNewTotal] = useState(0);
  useEffect(() => {
        if( !amount || !quantity ) {
            setTotal(0);
            return;
        }
        setTotal(amount*quantity);
        if (!newAmount || !newQuantity) {
            setNewTotal(0);
            return;
        }
        setNewTotal(newAmount*newQuantity);
        // console.log((total + newTotal) / (quantity + newQuantity));

        console.log("변경완료1");

    }, [amount, quantity, newAmount, newQuantity])

    function comma(str) {
        str = String(str);
        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }

    return (
        <div>
            <Navbar bg="dark" variant="dark">
                    <Navbar.Brand href="#home">Navbar</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Home</Nav.Link>
                        <Nav.Link href="#features">Features</Nav.Link>
                        <Nav.Link href="#pricing">Pricing</Nav.Link>
                    </Nav>
            </Navbar>
            <Container>
                <Row className="mt-5">
                    <Col>
                        <Table striped bordered hover variant="dark">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>기존 총 매수 주식</th>
                                <th>새로 매수하려는 주식</th>
                                <th>물타기 결과</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>매수금액</td>
                                <td><input type='text' value={amount} onChange={(e) => setAmount(Number(e.target.value))}/></td>
                                <td><input type='text' value={newAmount} onChange={(e) => setNewAmount(Number(e.target.value))}/></td>
                                <td>{isNaN((total+newTotal)/(quantity+newQuantity)) ? 0 : comma(Math.floor((total+newTotal)/(quantity+newQuantity)))}</td>
                            </tr>
                            <tr>
                                <td>수량</td>
                                <td><input type='text' value={quantity} onChange={(e) => setQuantity(Number(e.target.value))}/></td>
                                <td><input type='text' value={newQuantity} onChange={(e) => setNewQuantity(Number(e.target.value))}/></td>
                                <td>{quantity+newQuantity}</td>
                            </tr>
                            <tr>
                                <td>총액</td>
                                <td>{comma(total)}</td>
                                <td>{comma(newTotal)}</td>
                                <td>{comma(total+newTotal)}</td>
                            </tr>
                            </tbody>
                        </Table>
                    </Col>
                </Row>
            </Container>
        </div>
    );
}
