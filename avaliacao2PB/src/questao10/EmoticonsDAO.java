package questao10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmoticonsDAO {

	private Connection connection;

	public EmoticonsDAO(Connection connection) {
		this.connection = connection;
	}

	public void sentimentoEmoticon(String sentimento) {

		String sql = " INSERT INTO feedback (sentimento) VALUES (?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, sentimento);

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {

				while (rst.next()) {
					rst.getInt(1);
					
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
